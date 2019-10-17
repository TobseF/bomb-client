package bomb.client.module

import de.its.game.client.bomb.BombClient
import de.its.game.client.bomb.ResponseStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Bomb Client with modules. Use the correct module and solve it's puzzle to deactivate the bomb.
 * For help look into the bombs manual.
 */
internal class Module {

    private val bombClient = BombClient()

    @Test
    fun CONNECTION_MODULE() {
        val message = "" // <- Enter your solution here
        val bombResponse = bombClient.sendToBomb("connect", message)

        assertEquals(bombResponse.status, ResponseStatus.OK)
    }

    /**
     * @see solvePuzzle
     */
    @Test
    fun FLOATING_CHAOS_MODULE() {
        // Get the numbers from the bomb
        val bombNumbers = bombClient.readFromBomb("numbers").data
        // Find the solution yourself
        val sortedBombNumberSolution = solvePuzzle(bombNumbers)
        // Send your solution back
        val bombResponse = bombClient.sendToBomb("numbers", sortedBombNumberSolution)

        assertEquals(bombResponse.status, ResponseStatus.OK)
    }

    /**
     * @param numbers Numbers from Bomb
     */
    private fun solvePuzzle(numbers: String): String {
        // Enter your program HERE

        return "Your solution";
    }
}