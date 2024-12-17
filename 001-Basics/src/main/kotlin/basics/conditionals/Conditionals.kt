package basics.conditionals

fun main() {
    var max: Int
    val a = 10
    val b = 20

    // If-else
    if (a > b) {
        max = a
    } else {
        max = b
    }
    println("Max is $max")

    // If-else as expression
    max = if (a < b) a * 5 else b * 10
    println("Max is $max")

    // if-else-if as expression
    val maxLimit = 100
    val maxOrLimit =
        if (max > maxLimit) {
            max
        } else if (b > maxLimit) {
            b
        } else {
            maxLimit
        }

    // When as a statement and with subject
    when (maxOrLimit) {
        max -> println("maxOrLimit is equals max")
        b -> println("maxOrLimit is equals b")
        else -> println("maxOrLimit is nether max nor b")
    }

    // When as an expression
    val result =
        when (maxOrLimit) {
            max -> "maxOrLimit is equals max"
            b -> "maxOrLimit is equals b"
            else -> "maxOrLimit is nether max nor b"
        }
    println(result)

    // When without subject
    val x = 10
    when {
        x < 10 -> println("x is less than 10")
        x > 10 -> println("x is greater than 10")
        else -> println("x is equals to 10")
    }
}
