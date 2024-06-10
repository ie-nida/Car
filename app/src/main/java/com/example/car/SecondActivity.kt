package com.example.car

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var showPopupInstruct: ImageButton
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var thirdActivity: ImageButton
    private lateinit var fourthActivity: ImageButton
    private lateinit var fifthActivity: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showPopupInstruct = findViewById(R.id.open)
        showPopupInstruct.setOnClickListener {
            showPopup()
        }

        val secondActivity = findViewById<ImageButton>(R.id.SecondActivity)
        secondActivity.setOnClickListener {
            val intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }

        val imageButton1: ImageButton = findViewById(R.id.car1)
        thirdActivity = findViewById(R.id.arrow2)
        fourthActivity = findViewById(R.id.arrow3)
        fifthActivity = findViewById(R.id.arrow4)

        imageView1 = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView11)
        imageView3 = findViewById(R.id.imageView20)
        textView1 = findViewById(R.id.textView3)
        textView2 = findViewById(R.id.textView4)
        textView3 = findViewById(R.id.textView5)

        // Initially hide arrow image buttons
        thirdActivity.visibility = View.GONE
        fourthActivity.visibility = View.GONE
        fifthActivity.visibility = View.GONE

        imageButton1.setOnClickListener {
            // Show image and text for car1
            imageView1.visibility = View.VISIBLE
            imageView1.setImageResource(R.drawable.mclaren)
            textView1.text = "Mclaren"

            // Show thirdActivity when imageButton1 is clicked
            thirdActivity.visibility = View.VISIBLE

            // Hide fourthActivity and fifthActivity
            fourthActivity.visibility = View.GONE
            fifthActivity.visibility = View.GONE

            thirdActivity.setOnClickListener {
                val intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent)
            }

            // Hide image and text for car2 and car3
            imageView2.visibility = View.GONE
            textView2.text = ""
            imageView3.visibility = View.GONE
            textView3.text = ""
        }

        val imageButton2: ImageButton = findViewById(R.id.car2)
        val imageButton3: ImageButton = findViewById(R.id.car3)

        imageButton2.setOnClickListener {
            // Show image and text for car2
            imageView2.visibility = View.VISIBLE
            imageView2.setImageResource(R.drawable.ferrari)
            textView2.text = "Ferrari"

            // Show fourthActivity when imageButton2 is clicked
            fourthActivity.visibility = View.VISIBLE

            // Hide thirdActivity and fifthActivity
            thirdActivity.visibility = View.GONE
            fifthActivity.visibility = View.GONE

            fourthActivity.setOnClickListener {
                val intent = Intent(this, FourthActivity::class.java)
                startActivity(intent)
            }

            // Hide image and text for car1 and car3
            imageView1.visibility = View.GONE
            textView1.text = ""
            imageView3.visibility = View.GONE
            textView3.text = ""
        }

        imageButton3.setOnClickListener {
            // Show image and text for car3
            imageView3.visibility = View.VISIBLE
            imageView3.setImageResource(R.drawable.lambo1)
            textView3.text = "Lamborghini"

            // Show fifthActivity when imageButton3 is clicked
            fifthActivity.visibility = View.VISIBLE

            // Hide thirdActivity and fourthActivity
            thirdActivity.visibility = View.GONE
            fourthActivity.visibility = View.GONE

            fifthActivity.setOnClickListener {
                val intent = Intent(this, FifthActivity::class.java)
                startActivity(intent)
            }

            // Hide image and text for car1 and car2
            imageView1.visibility = View.GONE
            textView1.text = ""
            imageView2.visibility = View.GONE
            textView2.text = ""
        }
    }

    private fun showPopup() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_popup, null)

        val width = 800
        val height = 1250

        val open = PopupWindow(popupView, width, height, true)
        open.showAsDropDown(showPopupInstruct)
    }
}