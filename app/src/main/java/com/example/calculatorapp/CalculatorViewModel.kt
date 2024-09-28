package com.example.calculatorapp

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    fun addTwoNumbers(numOne: Int, numTwo: Int): Int {
        val answer = numOne + numTwo
        return answer
    }

    fun subtractTwoNumbers(numOne: Int, numTwo: Int): Int {
        val answer = numOne - numTwo
        return answer
    }

    fun multiplyTwoNumbers(numOne: Int, numTwo: Int): Int {
        val answer = numOne * numTwo
        return answer
    }

    fun divideTwoNumbers(numOne: Int, numTwo: Int): Int {
        val answer = numOne / numTwo
        return answer
    }



}