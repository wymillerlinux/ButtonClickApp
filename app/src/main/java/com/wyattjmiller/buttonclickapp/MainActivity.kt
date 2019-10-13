package com.wyattjmiller.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {
    // private var userInput: EditText? = null
    // private var button: Button? = null
    private var textView: TextView? = null
    //private var numberTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "OnCreate has been called!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.edittxt_01)
        val button = findViewById<Button>(R.id.btn_01)
        textView = findViewById<TextView>(R.id.txtview_01)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        userInput.setText("")

        button?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d(TAG, "OnClick has been called!")

                if (userInput.text.toString() == "") {
                    textView?.append("Enter your name in the field above.\n")
                } else {
                    textView?.append("Hello " + userInput.text + "!")
                    textView?.append("\n")
                    userInput.setText("")
                }
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart has been called!")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState has been called!")
        super.onRestoreInstanceState(savedInstanceState)
        // this is one way of getting back the savedInstanceState
        //
        //val savedString = savedInstanceState?.getString(TEXT_CONTENTS, "")
        //textView?.text = savedString
        //
        // this is the different way
        //
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        Log.d(TAG, "onResume has been called!")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause has been called!")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG, "onSaveInstanceState has been called!")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop has been called!")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart has been called!")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy has been called!")
        super.onDestroy()
    }

}
