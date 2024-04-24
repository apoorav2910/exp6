package com.example.exp6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var num : EditText
    lateinit var msg : EditText
    lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num = findViewById(R.id.num)
        msg = findViewById(R.id.msg)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener(){
            try {
                Toast.makeText(this, "Sending SMS...!", Toast.LENGTH_SHORT).show()
                sendSMS()
            }catch (e: Exception){
                Toast.makeText(this, "Invalid Inputs", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun sendSMS(){
        var phnNum = num.text.toString()
        var mess = msg.text.toString()

        var smang: SmsManager = SmsManager.getDefault()
        smang.sendTextMessage(phnNum, null, mess, null, null)
        Toast.makeText(this, "Message Sent!", Toast.LENGTH_LONG).show()

    }
}