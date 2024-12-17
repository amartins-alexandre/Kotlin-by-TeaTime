package com.example

import com.example.taxiway.contract.impl.Electronics
import com.example.taxiway.contract.impl.Food
import com.example.taxiway.contract.impl.Shoes
import com.example.taxiway.system.TaxSystem

fun main() {
    println("Hello, Taxiway!")

    val laptop =
        Electronics().apply {
            name = "Laptop"
            price = 1000.0
            quantity = 1
            calculateTotal()
        }

    val bigMac =
        Food().apply {
            name = "Big Mac"
            price = 9.29
            quantity = 1
            calculateTotal()
        }

    val nike =
        Shoes().apply {
            name = "Nike"
            price = 100.0
            quantity = 1
            calculateTotal()
        }

    val taxSystem =
        TaxSystem().apply {
            addProduct(laptop)
            addProduct(bigMac)
            addProduct(nike)
        }

    taxSystem.createReceipt()
    taxSystem.printReceipt()
}
