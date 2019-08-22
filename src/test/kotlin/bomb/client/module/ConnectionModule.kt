package bomb.client.module

import de.its.game.client.bomb.BombClient
import de.its.game.client.bomb.ResponseStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ConnectionModule {

    private val bombClient = BombClient()

    @Test
    fun sendToBomb() {
        val message = ""
        val bombResponse = bombClient.sendToBomb("connect", message)


        assertEquals(bombResponse.status, ResponseStatus.OK)
    }
}