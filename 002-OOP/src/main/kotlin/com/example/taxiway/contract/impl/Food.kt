package com.example.taxiway.contract.impl

class Food : Product() {
    private var expirationDate: String = ""

    override fun calculateTax(): Double = total * 0.05

    override fun toString(): String = "Food(name='$name', price=$price, quantity=$quantity, total=$total, expirationDate='$expirationDate')"
}
