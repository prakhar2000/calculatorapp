package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class buttonactivity : AppCompatActivity() {

    lateinit var btn_click_me: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttonactivity)
        btn_click_me=findViewById(R.id.btn_click_me) as Button
        btn_click_me.setOnClickListener(
            View.OnClickListener {
                btn_click_me.text="clicked"
            }
        )

        btn_click_me.setOnLongClickListener(
            View.OnLongClickListener {
                btn_click_me.text="longclick"
                true
            }
        )
    }
}