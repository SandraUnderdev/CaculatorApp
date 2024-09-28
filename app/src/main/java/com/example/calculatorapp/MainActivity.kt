package com.example.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userText : String? = null
//    private val calculatorViewModel: CalculatorViewModel by viewModels()
//    private var buttonClicked = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.username.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed before text changes
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               userText = s.toString()
               val  displayText = "WELCOME ${userText!!.uppercase()}!"
                binding.welcome.text = displayText
            }

            override fun afterTextChanged(s: Editable?) {
                    // No action needed before text changes
            }
        } )

        binding.clickMe.setOnClickListener {
            if(userText.isNullOrEmpty()){
                Toast.makeText(this, "Enter name first", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("name",userText )
                startActivity(intent)
            }

        }
    }
}
