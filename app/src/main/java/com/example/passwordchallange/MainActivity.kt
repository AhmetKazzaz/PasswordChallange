package com.example.passwordchallange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    var binaryEmail = ""
    var shift = 0
    var listOfPossiblePasswords: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDecrypt.setOnClickListener {
            shift = 26
            for (i in 0..shift) {
                encrypt(i)
                passwords.text = listOfPossiblePasswords.toString()
            }
        }
    }

    private fun encrypt(shift: Int) {
        var ciphertext = ""
        var alphabet: Char
        for (i in etEmail.text.toString().indices) {
            alphabet = etEmail.text.toString()[i]
            when (alphabet) {
                in 'a'..'z' -> {
                    alphabet = (alphabet.code + shift).toChar()
                    if (alphabet > 'z') {
                        alphabet = (alphabet + 'a'.code - 'z'.code - 1)
                    }
                    ciphertext += alphabet
                }
                in 'A'..'Z' -> {
                    alphabet = (alphabet.code + shift).toChar()
                    if (alphabet > 'Z') {
                        alphabet = (alphabet + 'A'.code - 'Z'.code - 1)
                    }
                    ciphertext += alphabet
                }
                else -> {
                    ciphertext += alphabet
                }
            }
        }
        listOfPossiblePasswords.add(ciphertext)
    }

}