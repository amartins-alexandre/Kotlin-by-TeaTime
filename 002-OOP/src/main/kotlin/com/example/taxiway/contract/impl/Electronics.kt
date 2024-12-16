package com.example.taxiway.contract.impl

class Electronics : Product() {
    private var warranty: Int = 0

    override fun calculateTax(): Double = total * 0.15

    override fun toString(): String = "Electronics(name='$name', price=$price, quantity=$quantity, total=$total, warranty=$warranty)"
}
