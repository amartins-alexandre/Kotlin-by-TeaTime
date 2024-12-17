import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Detailed Explanation
 *
 * runBlocking:
 *
 * - It is a blocking function that creates a coroutine scope and blocks the main thread until all coroutines inside it are completed.
 * - Here we use it only for didactic purposes and to test coroutines.
 *
 * launch:
 *
 * - It is a builder function that creates a new coroutine.
 * - The coroutine created by launch does not return any value. It is used when you want to execute something asynchronously.
 *
 * delay:
 *
 * - delay is a suspending function. Unlike Thread.sleep, it does not block the thread, it only suspends the coroutine, allowing other coroutines to be executed.
 *
 * Main thread:
 *
 * - Kotlin coroutines allow executing asynchronous tasks without blocking the main thread.
 */
fun main() =
    runBlocking {
        // this: main CoroutineScope
        println("Start of the program - ${Thread.currentThread().name}")

        launch {
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("Coroutines are asynchronous! - ${Thread.currentThread().name}")
        }

        println("Still in the main thread - ${Thread.currentThread().name}")
        delay(2000L) // block the main thread for 2 seconds to keep JVM alive

        println("End of the program - ${Thread.currentThread().name}")
    }
