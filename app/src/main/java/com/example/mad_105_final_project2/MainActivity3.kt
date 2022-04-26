package com.example.mad_105_final_project2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*********************************************************************************
 * MAD-105 Final Project to get user input on a cup of Tea (ie: similar to Starbucks, but with tea)
 * Author:  Al Jette
 * Date: April-2022
 * Third Screen (MainActivity3) displays user selected details on the cup of tea
 *
 * Layout IDs and what they contain
 *   idPrintName (from layout) = displayName => display customerName from Screen1
 *   idPrintPhone (from layout) = displayPhone => display customerPhone from Screen1
 *   idCustSelTeaType (from layout) = displayCustTeaType => displays customer tea type (black, green, herbal)
 *   idTeaSize (from layout) = displayCustTeaSize => displays customer tea size (small, med, large)
 *   idTeaSugar (from layout) = displayCustTeaSugar => displays if customer wants sugar (yes or no)
 *   idTeaCream (from layout) = displayCustTeaCream => displays if customer wants cream (yes or no)
 *
 * First and Second Screen Variables passed to MainActivity3
 *   customerName: the customer name (from screen1 and 2)
 *   customerPhone: the customer's phone (from screen1 and 2)
 *   teaType (string): based on the Buttons for teaType, will be: Black, Green or Herbal
 *   teaSize (string): based on the user selected tea size: 1 (small), 2 (medium), 3 (large)
 *   sugar (string): yes or no based on the user selection
 *   cream (string): yes or no based on the user selection
 */

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

        // Setters and Getters
        val displayName: TextView = findViewById(R.id.idPrintName)
        val displayPhone: TextView = findViewById(R.id.idPrintPhone)
        val displayCustTeaType: TextView = findViewById(R.id.idCustSelTeaType)
        val displayCustTeaSize: TextView = findViewById(R.id.idTeaSize)
        val displayCustTeaSugar: TextView = findViewById(R.id.idTeaSugar)
        val displayCustTeaCream: TextView = findViewById(R.id.idTeaCream)

        // Collect information passed from MainActivity2.kt and declare local variables for input
        val extras = intent.extras
        if (extras != null) {
            customerName = extras.getString("CustName")
            customerPhone = extras.getString("CustPhone")
            teaType = extras.getString("TeaType")
            teaSize = extras.getString( "TeaSize")
            sugar = extras.getString("Sugar")
            cream = extras.getString ("Cream")
        }

        // Convert string numerical tea size value to a respective text
        var custSelectTeaSizeText = "Out of Bound"
        when (teaSize?.toInt()) {
            1 -> custSelectTeaSizeText = "Small"
            2 -> custSelectTeaSizeText = "Medium"
            3 -> custSelectTeaSizeText = "Large"
            else -> custSelectTeaSizeText = "Out of Bound"
        }

        // Display customer selected tea order
        displayName.text = customerName
        displayPhone.text = customerPhone
        displayCustTeaType.text = teaType
        displayCustTeaSize.text = custSelectTeaSizeText
        displayCustTeaSugar.text = sugar
        displayCustTeaCream.text = cream
    }
}