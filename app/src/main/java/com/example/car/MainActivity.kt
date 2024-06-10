package com.example.car

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var showPopupInstruct: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStarted = findViewById<Button>(R.id.getstarted)
        getStarted.setOnClickListener {
            val intent = Intent (this, Login::class.java)
            startActivity(intent) // You need to start the SecondActivity
        }

        showPopupInstruct = findViewById(R.id.open)
        showPopupInstruct.setOnClickListener {
            showPopup()
        }
        // Move the showPopup function outside of onCreate
    }

    private fun showPopup() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_popup,null)

        val width = 800
        val height = 1250

        val open = PopupWindow(popupView, width, height, true)
        open.showAsDropDown(showPopupInstruct)

    }


}
