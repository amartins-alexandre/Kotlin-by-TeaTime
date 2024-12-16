package com.example.taxiway.contract.impl

class Shoes : Product() {
    private var size: Int = 0

    override fun calculateTax(): Double = total * 0.05

    override fun toString(): String = "Shoes(name='$name', price=$price, quantity=$quantity, total=$total, size=$size)"
}
