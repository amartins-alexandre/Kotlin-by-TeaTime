package basics.functions

// A function with two Int parameters and Int return type
fun add(
    a: Int,
    b: Int,
): Int = a + b

// A function of body can be a single expression
fun sum(
    a: Int,
    b: Int,
) = a + b

// A function that returns no meaningful value
fun printSum(
    a: Int,
    b: Int,
) {
    println("The sum of $a and $b is ${a + b}")
}

// A function with parameters lambda
fun printSumWithLambda(
    a: Int,
    b: Int,
    printer: (result: Int) -> Unit,
) {
    printer(a + b)
}

// A function with a variable number of arguments (vararg)
fun sumAll(vararg numbers: Int): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    return sum
}

// Function with variable if type T, also known as a generic function
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

// Function infix
infix fun Int.plus(other: Int): Int = this + other

// tailrec Function
tailrec fun factorial(
    n: Int,
    run: Int = 1,
): Int = if (n == 1) run else factorial(n - 1, run * n)

fun main() {
    val result = add(2, 3)
    println("The result the addition is: $result")

    val sumResult = sum(2, 3)
    println("The result the sum is: $sumResult")

    printSum(2, 3)

    printSumWithLambda(2, 3) {
        println("The sum of 2 and 3 is $it")
    }

    val sumAllResult = sumAll(1, 2, 3, 4, 5)
    println("The result the sumAll is: $sumAllResult")

    val list = asList(1, 2, 3, 4, 5)
    println("The result the asList is: $list")

    val list2 = asList("a", "b", "c", "d", "e")
    println("The result the asList is: $list2")

    val infixResult = 2 plus 3 // Is the same as 2.plus(3)
    println("The result the infix is: $infixResult")

    val factorialResult = factorial(5)
    println("The result the factorial is: $factorialResult")
}
