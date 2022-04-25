package com.example.mad_105_final_project2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private var customerName: String? = ""
    private var customerPhone: String? = ""
    private var teaType: String? = ""
    private var teaSize: String? = ""
    private var sugar: String? = ""
    private var cream: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val displayName: TextView = findViewById(R.id.idPrintName)
        val displayPhone: TextView = findViewById(R.id.idPrintPhone)
        val displayCustTeaType: TextView = findViewById(R.id.idCustSelTeaType)
        val displayCustTeaSize: TextView = findViewById(R.id.idTeaSize)
        val displayCustTeaSugar: TextView = findViewById(R.id.idTeaSugar)
        val displayCustTeaCream: TextView = findViewById(R.id.idTeaCream)

        val extras = intent.extras
        if (extras != null) {
            customerName = extras.getString("CustName")
            customerPhone = extras.getString("CustPhone")
            teaType = extras.getString("TeaType")
            teaSize = extras.getString( "TeaSize")
            sugar = extras.getString("Sugar")
            cream = extras.getString ("Cream")
        }

        displayName.text = customerName
        displayPhone.text = customerPhone
        displayCustTeaType.text = teaType
        displayCustTeaSize.text = teaSize
        displayCustTeaSugar.text = sugar
        displayCustTeaCream.text = cream
    }
}