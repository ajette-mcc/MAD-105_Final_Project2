package com.example.mad_105_final_project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private var customerName: String? = ""
    private var customerPhone: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val displayName: TextView = findViewById(R.id.idPrintName)
        val displayPhone: TextView = findViewById(R.id.idPrintPhone)
        val screen3Btn = findViewById<Button>(R.id.idButtonToScr3)

        val extras = intent.extras
        if (extras != null) {
            customerName = extras.getString("CustName")
            customerPhone = extras.getString("CustPhone")
        }

        displayName.text = customerName
        displayPhone.text = customerPhone

        screen3Btn.setOnClickListener {
            val nextScreen = Intent(this@MainActivity2, MainActivity3::class.java)
            nextScreen.putExtra("CustName", customerName.toString())
            nextScreen.putExtra("CustPhone", customerPhone.toString())

            startActivity(nextScreen)
        }
    }
}