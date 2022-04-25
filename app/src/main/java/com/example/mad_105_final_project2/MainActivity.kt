package com.example.mad_105_final_project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*********************************************************************************
 * MAD-105 Final Project to get user input on a cup of Tea (ie: similar to Starbucks, but with tea)
 * Author:  Al Jette
 * Date: April-2022
 * First Screen (MainActivity) collects Customer Name & Phone #
 * Second Screen (MainActivity2) collects details on the cup of tea
 * Third Screen (MainActivity3) displays the customer info and tea ordered
 * Fourth Screen (MainActivity4) says "Thank you for your order"
 *
 * First Screen Variables
 *   idCustName (from layout) = customerName => the customer name
 *   idCustPhone (from layout) = customerPhone => the customer's phone
 *   idButtonToScr2 (from layout) = screen2Btn => goes to screen 2 (MainActivity2)
 *
 *   Software checks to ensure customerName and customerPhone are NOT Blank in the routine checkData
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customerName = findViewById<TextView>(R.id.idCustName)
        val customerPhone = findViewById<TextView>(R.id.idCustPhone)
        val screen2Btn = findViewById<Button>(R.id.idButtonToScr2)

        // If user clicks button to move to screen2 and if checkData routine says data is good (True)
        screen2Btn.setOnClickListener {
            if (checkData()) {
                val nextScreen = Intent(this@MainActivity, MainActivity2::class.java)
                // pass customerName and customerPhone to MainActivity2 and start MainActivity2
                nextScreen.putExtra("CustName", customerName.text.toString())
                nextScreen.putExtra("CustPhone", customerPhone.text.toString())

                startActivity(nextScreen)
            }
        }
    }
    private fun checkData(): Boolean {
        val customerName = findViewById<TextView>(R.id.idCustName)
        val customerPhone = findViewById<TextView>(R.id.idCustPhone)

        if (customerName.text.toString().isEmpty()) {
            // return error, want at least some string for the customer name
            customerName.error = "Invalid Name"
            customerName.requestFocus()
            return false
        }

        if (customerPhone.text.toString().isEmpty()) {
            // return error, want at least some string for the phone number
            customerPhone.error = "Invalid Phone"
            customerPhone.requestFocus()
            return false
        }

        return true

    }

}