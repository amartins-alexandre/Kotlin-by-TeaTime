package com.example.taxiway.contract.impl

import com.example.taxiway.contract.CalculateTax

open class Product : CalculateTax {
    var name: String = ""
    var price: Double = 0.0
    var quantity: Int = 0
    var total: Double = 0.0

    fun calculateTotal() {
        total = price * quantity
    }

    override fun calculateTax(): Double = total * 0.1

    override fun toString(): String = "Product(name='$name', price=$price, quantity=$quantity, total=$total)"
}
