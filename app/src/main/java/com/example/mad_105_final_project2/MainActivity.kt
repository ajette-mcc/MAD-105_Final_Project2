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

        public var customerNameVar: String = "Joe"

        screen2Btn.setOnClickListener {
            var intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
    }
}