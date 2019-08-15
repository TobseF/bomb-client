package de.its.game.client.bomb

import de.its.game.client.bomb.BombServerConfig.Android
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.logging.Level.WARNING
import java.util.logging.Logger


val log = Logger.getLogger(BombClient::javaClass.name)

class BombClient(private val config: BombServerConfig = Android) {

    enum class RequestMethod { POST, GET }

    fun unlockAction(endpoint: String, puzzleSolver: (String) -> String): PuzzleResponse {
        val puzzleData = readFromBomb(endpoint)
        if (puzzleData.status == ResponseStatus.OK) {
            val solvedPuzzleData = puzzleSolver.invoke(puzzleData.data)
            return sendToBomb(endpoint, solvedPuzzleData)
        }
        return PuzzleResponse.FALSE
    }

    fun readFromBomb(endpoint: String): PuzzleResponse {
        return connectToBomb(endpoint, RequestMethod.GET, "")
    }

    fun sendToBomb(endpoint: String, data: String): PuzzleResponse {
        return connectToBomb(endpoint, RequestMethod.POST, data)
    }

    private fun connectToBomb(endpoint: String, requestMethod: RequestMethod, data: String): PuzzleResponse {
        try {
            val url = URL("http://${config.ip}:${config.port}/$endpoint")
            val conn = url.openConnection() as HttpURLConnection
            conn.doOutput = true
            conn.requestMethod = requestMethod.name
            conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8")

            if (requestMethod == RequestMethod.POST) {
                val os = conn.outputStream
                os.write(data.toByteArray())
                os.flush()
            }

            if (conn.responseCode != HttpURLConnection.HTTP_CREATED) {
                log.log(WARNING, "Failed to connect with bomb " + conn.responseCode)
            }
            val puzzleStatus = parseBomHeader(conn.getHeaderField(ResponseHeaderKey.BombKey.code))

            val output = readText(conn)
            conn.disconnect()
            return PuzzleResponse(status = puzzleStatus, data = output)

        } catch (e: Throwable) {
            log.log(WARNING, "Failed to connect with bomb ", e)
        }
        return PuzzleResponse.FALSE
    }

    private fun readText(conn: HttpURLConnection): String {
        val br = BufferedReader(InputStreamReader(conn.inputStream))
        val output = br.readText()
        return output
    }

    private fun parseBomHeader(headerValue: String?): ResponseStatus {
        return ResponseStatus.values().find { it.name == headerValue } ?: ResponseStatus.FALSE
    }

}