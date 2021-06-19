package com.example.passwordchallange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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