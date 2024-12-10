fun main() {
    // Set the value of a variable without specifying the type
    val name = "John Doe" // var is immutable
    var age = 25 // val is mutable
    println("Today $name is $age years old")

    // Change the value of a variable
    age += 1
    println("The next year, $name will be $age years old")

    // Declare a variable with a specific type
    val pi: Double = 3.14159
    println("The value of pi is $pi")
}
