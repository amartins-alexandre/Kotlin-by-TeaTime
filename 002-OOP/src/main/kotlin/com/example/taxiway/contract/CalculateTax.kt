package com.example.taxiway.contract

fun interface CalculateTax {
    /**
     * Calculate tax for the product based on the total price
     * That method can be overridden to calculate tax based on the product
     *
     * @return tax amount
     */
    fun calculateTax(): Double
}
