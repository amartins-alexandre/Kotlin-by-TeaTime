package coroutines.launchvsasync

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Detailed Explanation
 *
 * launch:
 * - Does not return any value (Job).
 * - Ideal for asynchronous tasks that do not need a return value.
 *
 * async:
 * - Returns a Deferred object, which represents a future value.
 * - To access the value, you use await().
 *
 * await():
 * - Suspends execution until the value is returned by the async coroutine.
 *
 * join():
 * - Waits for the completion of a coroutine started with launch.
 */
fun main() =
    runBlocking {
        println("Start: ${Thread.currentThread().name}")

        val job =
            launch {
                delay(1000)
                println("Executed by launch: ${Thread.currentThread().name}")
            }

        val result =
            async {
                delay(1000)
                println("Executed by async: ${Thread.currentThread().name}")
                42 // return@async
            }

        println("Result of the async: ${result.await()}") // wait and get the result of the async

        job.join() // wait for the end of the coroutine launched by launch

        println("End: ${Thread.currentThread().name}")
    }
