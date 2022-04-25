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
 * First Screen Variables passed to MainActivity2 and MainActivity3
 *   customerName => the customer name
 *   customerPhone => the customer's phone
 *
 * Second Screen Variables
 *   idPrintName (from layout) = displayName => display customerName from Screen1
 *   idPrintPhone (from layout) = displayPhone => display customerPhone from Screen1
 *   idBtnBlackTea (from layout) = teaTypeBlack
 *   idBtnGreenTea (from layout) = teaTypeGreen
 *   idBtnHerbalTea (from layout) = teaTypeHerbal
 *   idToggleSugar (from layout)
 *   idToggleCream (from layout)
 *   idSeekBarSize (from layout) = custSelectTeaSize:  Tea size being ordered 1=small, 2=medium, 3=large
 *   idSeekBarText (from layout) = custSelectTeaSizeText: Displays the tea size selected by the customer
 *   idButtonToScr3 (from layout) = screen3Btn => goes to screen 3 (MainActivity3)
 *
 *   teaType (string): based on the Buttons for teaType, will be: Black, Green or Herbal
 *   teaSelected (Boolean): None of the radio buttons for teaType is initially selected, this is False until the user selects a teaType
 *   sugar (string): yes or no based on idToggleSugar
 *   cream (string): yes or no based on idToggleCream
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

        var custSelectTeaSizeText = "Out of Bound"
        when (teaSize?.toInt()) {
            1 -> custSelectTeaSizeText = "Small"
            2 -> custSelectTeaSizeText = "Medium"
            3 -> custSelectTeaSizeText = "Large"
            else -> custSelectTeaSizeText = "Out of Bound"
        }

        displayName.text = customerName
        displayPhone.text = customerPhone
        displayCustTeaType.text = teaType
        displayCustTeaSize.text = custSelectTeaSizeText
        displayCustTeaSugar.text = sugar
        displayCustTeaCream.text = cream
    }
}