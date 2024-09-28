package com.example.calculatorapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityCalculatorBinding
import com.example.calculatorapp.databinding.ActivityMainBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private val calculatorViewModel: CalculatorViewModel by viewModels()
    private var buttonClicked = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val username = intent.getStringExtra("name")
        val displayMessage = "$username perform any calculations"

        binding.add.setOnClickListener() {
            buttonClicked = "plus"
        }

        binding.sub.setOnClickListener() {
            buttonClicked = "subtract"
        }

        binding.div.setOnClickListener() {
            buttonClicked = "divide"
        }

        binding.multi.setOnClickListener() {
            buttonClicked = "multiply"
        }

        binding.message.text = displayMessage

        binding.answerBtn.setOnClickListener() {
            val firstText = binding.firstNum.text.toString()
            val secondText = binding.secondNum.text.toString()
            if(firstText.isEmpty() || secondText.isEmpty())
            {
                Toast.makeText(this, "You must enter a number", Toast.LENGTH_SHORT).show()
            }else {
                val valueOne = firstText.toInt()
                val valueTwo = secondText.toInt()

                val plusTotal = calculatorViewModel.addTwoNumbers(valueOne, valueTwo)
                val subTotal = calculatorViewModel.subtractTwoNumbers(valueOne, valueTwo)
                val divideTotal = calculatorViewModel.divideTwoNumbers(valueOne, valueTwo)
                val multiTotal = calculatorViewModel.multiplyTwoNumbers(valueOne, valueTwo)


                val result: Int = when (buttonClicked) {
                    "plus" -> plusTotal
                    "subtract" -> subTotal
                    "multiply" -> multiTotal
                    "divide" -> divideTotal
                    else -> 0
                }

                binding.answerText.text = result.toString()
                Toast.makeText(this, "${binding.answerText.text}", Toast.LENGTH_SHORT).show()

                binding.clear.setOnClickListener{
                    binding.firstNum.text.clear()
                    binding.secondNum.text.clear()
                    binding.answerText.text = ""
                }

            }

        }

    }
}