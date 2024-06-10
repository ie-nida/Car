package com.example.car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class FourthActivity : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this,SeventhActivity::class.java)
            startActivity(intent)
            finish()
        },3000) // delayed 3 seconds to open the MainActivity App
    }
}
