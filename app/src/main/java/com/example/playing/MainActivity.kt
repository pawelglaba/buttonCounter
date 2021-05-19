package com.example.playing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //private var editText: EditText? = null
    private var userInput: EditText? = null
    private var button: Button? = null
    private var textView: TextView? = null
    //4
    private var nextActivityButton: Button? = null

    //2

    private var numTimesClicked = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        userInput = findViewById<EditText>(R.id.userInput)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.printText)
        //3
        textView?.text = ""
        textView?.movementMethod= ScrollingMovementMethod()
        //4
        nextActivityButton = findViewById(R.id.nextButton)

        nextActivityButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                openActivity2();
            }
        })



        //2

        button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                numTimesClicked += 1
                textView?.append("\n The button got tapped by ${userInput?.text} $numTimesClicked time")
                //3
                if(numTimesClicked !=1){
                    textView?.append("s")

                }
            }
        })


    }
    //4
    private fun openActivity2(){
        val intent= Intent(this, secondActivity::class.java)
        startActivity(intent)
    }

}