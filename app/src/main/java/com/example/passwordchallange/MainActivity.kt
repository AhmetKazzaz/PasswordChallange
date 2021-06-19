package com.example.passwordchallange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var binaryEmail = ""
    var shift = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etEmail.doOnTextChanged { text, _, _, _ ->
            binaryEmail = convertEmailToBinary(text.toString())
            tvBinaryEmail.text = binaryEmail
        }
        etEmail.doAfterTextChanged {
            shift = 0 // reset to 0
            shift = sumBinaryDigits(binaryEmail)
            tvShiftNumber.text = shift.toString()
        }
    }

    private fun sumBinaryDigits(binaryEmail: String): Int {
        var sum = 0
        val charArray = binaryEmail.toCharArray()
        charArray.forEach { character ->
            sum += character.digitToInt()
        }
        return sum
    }

    private fun convertEmailToBinary(emailToConvert: String): String {
        val bytesFromString = emailToConvert.toByteArray()
        val result = StringBuilder()
        for (byte in bytesFromString) {
            var temp = byte.toInt()
            (0..7).forEach { _ ->
                result.append(if (temp and 128 == 0) 0 else 1)
                temp = temp shl 1
            }
        }
        return result.toString()
    }

}