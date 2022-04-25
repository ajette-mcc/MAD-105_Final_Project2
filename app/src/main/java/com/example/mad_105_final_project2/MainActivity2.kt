package com.example.mad_105_final_project2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

/*********************************************************************************
 * MAD-105 Final Project to get user input on a cup of Tea (ie: similar to Starbucks, but with tea)
 * Author:  Al Jette
 * Date: April-2022
 * Second Screen (MainActivity2) collects details on the cup of tea
 *
 * First Screen Variables passed to MainActivity2
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

class MainActivity2 : AppCompatActivity() {

    private var customerName: String? = ""
    private var customerPhone: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Setters and Getters
        val displayName: TextView = findViewById(R.id.idPrintName)
        val displayPhone: TextView = findViewById(R.id.idPrintPhone)
        val rbTeaBlack = findViewById<RadioButton>(R.id.idBtnBlackTea)
        val rbTeaGreen = findViewById<RadioButton>(R.id.idBtnGreenTea)
        val rbTeaHerbal = findViewById<RadioButton>(R.id.idBtnHerbalTea)
        val custSelectTeaSize: SeekBar = findViewById(R.id.idSeekBarSize)
        val custSelectTeaSizeText: TextView = findViewById(R.id.idSeekBarText)
        val custSelectSugar:  ToggleButton = findViewById(R.id.idToggleSugar)
        val custSelectCream: ToggleButton = findViewById(R.id.idToggleCreamer)
        val screen3Btn = findViewById<Button>(R.id.idButtonToScr3)

        // Collect information passed in from MainActivity.kt and declare local variables for such input
        val extras = intent.extras
        if (extras != null) {
            customerName = extras.getString("CustName")
            customerPhone = extras.getString("CustPhone")
        }

        // Display Name and Phone passed from MainActivity.kt
        displayName.text = customerName
        displayPhone.text = customerPhone

        // Local variables (noted above)
        var custSelectedTeaSize: Int = 2
        var teaType = "None"
        var teaSelected = false
        var sugar = "None"
        var cream = "None"

        // Detect when customer selects a type of Tea (Black, Green, Herbal)
        rbTeaBlack.setOnClickListener {
//            Toast.makeText(applicationContext, "Black Tea", android.widget.Toast.LENGTH_LONG).show()
            teaType = "Black"
            teaSelected = true
        }

        rbTeaGreen.setOnClickListener {
//            Toast.makeText(applicationContext, "Green Tea", android.widget.Toast.LENGTH_LONG).show()
            teaType = "Green"
            teaSelected = true
        }

        rbTeaHerbal.setOnClickListener {
//            Toast.makeText(applicationContext, "Herbal Tea", android.widget.Toast.LENGTH_LONG).show()
            teaType = "Herbal"
            teaSelected = true
        }

        // Detect when customer toggles Sugar Button and respectively set variable "sugar"
        custSelectSugar.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                sugar = "Yes"
//                Toast.makeText(applicationContext, "Sugar", android.widget.Toast.LENGTH_LONG).show()
            } else {
//                Toast.makeText(applicationContext, "No Sugar", android.widget.Toast.LENGTH_LONG).show()
                sugar = "No"
            }
        }

        // Detect when customer toggles Cream Button and respectively set variable "cream"
        custSelectCream.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                cream = "Yes"
//                Toast.makeText(applicationContext, "Cream", android.widget.Toast.LENGTH_LONG).show()
            } else {
//                Toast.makeText(applicationContext, "No Cream", android.widget.Toast.LENGTH_LONG).show()
                cream = "No"
            }
        }

        //  When user moves the Seekbar, retrieve new value and update seekbarOutputText
        custSelectTeaSize.run {

            //  When user moves the Seekbar, retrieve new value and update seekbarOutputText
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    custSelectedTeaSize = p1
                    when (custSelectedTeaSize) {
                        1 -> custSelectTeaSizeText.text = "Small"
                        2 -> custSelectTeaSizeText.text = "Medium"
                        3 -> custSelectTeaSizeText.text = "Large"
                        else -> custSelectTeaSizeText.text = "Out of Bound"
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })
        }

        // When customer selects Next, confirm a tea type is selected, and pass info to MainActivity3 (Screen3)
        screen3Btn.setOnClickListener {
            if (teaSelected) {
                val nextScreen = Intent(this@MainActivity2, MainActivity3::class.java)
                nextScreen.putExtra("CustName", customerName.toString())
                nextScreen.putExtra("CustPhone", customerPhone.toString())
                nextScreen.putExtra("TeaType", teaType)
                nextScreen.putExtra("TeaSize", custSelectedTeaSize.toString())
                nextScreen.putExtra("Sugar", sugar)
                nextScreen.putExtra("Cream", cream)

                startActivity(nextScreen)
            } else {
                // Give message for user to select a Type of Tea befor they can proceed
                Toast.makeText(applicationContext, "Please Select Type of Tea", android.widget.Toast.LENGTH_LONG).show()
            }
        }
    }
}