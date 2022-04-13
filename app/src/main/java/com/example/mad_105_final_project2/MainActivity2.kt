package com.example.mad_105_final_project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private var customerName: String? = ""
    private var customerPhone: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val displayName: TextView = findViewById(R.id.idPrintName)
        val displayPhone: TextView = findViewById(R.id.idPrintPhone)
        val custSelectTeaSize: SeekBar = findViewById(R.id.idSeekBarSize)
        val custSelectTeaSizeText: TextView = findViewById(R.id.idSeekBarText)
        var custSelectedTeaSize: Int = 2


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
                    //                     seekbarOutputText.text = "TinyFine"
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })
        }

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