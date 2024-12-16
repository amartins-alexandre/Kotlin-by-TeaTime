package com.example.taxiway.system

import com.example.taxiway.contract.impl.Product
import java.math.BigDecimal
import java.math.RoundingMode

class TaxSystem {
    private val products = mutableListOf<Product>()
    private val receipt = StringBuilder()

    fun addProduct(product: Product) {
        products.add(product)
    }

    private fun calculateTotalTax(): BigDecimal {
        val totalTax = products.sumOf { it.calculateTax() }
        return BigDecimal(totalTax).setScale(2, RoundingMode.HALF_UP)
    }

    private fun calculateTotalPrice(): BigDecimal {
        val totalPrice = products.sumOf { it.total }
        return BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP)
    }

    fun createReceipt() {
        receipt.append("Receipt\n")
        products.forEach {
            receipt.append(it.toString())
            receipt.append("\n")
        }
        receipt.append("Total Tax: ${calculateTotalTax()}\n")
        receipt.append("Total Price: ${calculateTotalPrice()}\n")
    }

    fun printReceipt() {
        println(receipt)
    }
}
