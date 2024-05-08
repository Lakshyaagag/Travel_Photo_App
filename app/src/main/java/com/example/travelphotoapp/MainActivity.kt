package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image: ImageView
    var places = arrayOf("Seven Wonders","Garadiya Mahadev","River Front","Oxyzone Park","Jal Mandir")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forward = findViewById<ImageButton>(R.id.btnforward)
        val previous = findViewById<ImageButton>(R.id.btnprevious)
        val placeName = findViewById<TextView>(R.id.pvname)

        forward.setOnClickListener {
            //i want to get the next image
            var idCurrentImageString = "pic$currentImage"

            // i have to get the integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage +1)%5
            var idImageToShowstring = "pic$currentImage"
            var idImageToShow = this.resources.getIdentifier(idImageToShowstring,"id",packageName)
            image = findViewById(idImageToShow)
            image.alpha = 1f

            placeName.text = places[currentImage]


        }

        previous.setOnClickListener{
            var idCurrentImageString = "pic$currentImage"

            // i have to get the integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage -1)%5
            var idImageToShowstring = "pic$currentImage"
            var idImageToShow = this.resources.getIdentifier(idImageToShowstring,"id",packageName)
            image = findViewById(idImageToShow)
            image.alpha = 1f

            placeName.text = places[currentImage]


        }
    }
}