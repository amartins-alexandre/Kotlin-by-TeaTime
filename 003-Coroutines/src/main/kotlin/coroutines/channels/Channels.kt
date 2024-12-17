@file:Suppress("ktlint:standard:no-wildcard-imports")

package coroutines.channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

fun main(): Unit =
    runBlocking {
        closingAndInteractionChannel()

        launch {
            println()
            println("Start Producer!")
            val squares = producerSquares()
            squares.consumeEach { println(it) }
            println("Done Producer!")
        }
    }

suspend fun closingAndInteractionChannel() =
    coroutineScope {
        println("Start Channels")

        val channel = Channel<Int>()

        launch {
            for (x in 1..5) channel.send(x * x)
            channel.close()
        }

        for (y in channel) println(y)
        println("Done Channels!")
    }

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.producerSquares(): ReceiveChannel<Int> =
    produce {
        for (x in 1..5) send(x * x)
    }
