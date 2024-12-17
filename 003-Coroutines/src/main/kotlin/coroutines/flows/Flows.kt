package coroutines.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * Detailed Explanation
 *
 * flow:
 *
 * - flow {} creates a data flow that emits values sequentially.
 * - Inside the flow, we use emit() to send values.
 *
 * collect:
 *
 * - The collect operator is used to collect the values emitted by the flow.
 *
 * delay:
 *
 * - Can be used inside the flow to simulate asynchronous operations, such as API calls.
 */
fun main() =
    runBlocking {
        println("Start the Flow")

        // Create a flow
        val flow =
            flow {
                for (i in 1..3) {
                    delay(1000) // Emulate an asynchronous operation
                    emit(i) // Emit the next value
                }
            }

        // Collect the data flow
        flow.collect {
            println("Received: $it")
        }

        println("End the Flow")
    }
