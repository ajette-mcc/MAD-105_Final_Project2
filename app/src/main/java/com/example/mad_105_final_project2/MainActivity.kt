package com.example.mad_105_final_project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customerName = findViewById<TextView>(R.id.idCustName)
        val customerPhone = findViewById<TextView>(R.id.idCustPhone)
        val screen2Btn = findViewById<Button>(R.id.idButtonToScr2)

        screen2Btn.setOnClickListener {
            val nextScreen = Intent (this@MainActivity, MainActivity3::class.java)
            nextScreen.putExtra("CustName", customerName.text.toString())
            nextScreen.putExtra( "CustPhone", customerPhone.text.toString())

            startActivity(nextScreen)
        }
    }
}