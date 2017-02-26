package com.app.alex.bax

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    fun initListeners() {
        btn_timer.setOnClickListener {
            createTimerIntent()
        }
    }

    fun createTimerIntent() {
        val timerIntent: Intent = Intent(baseContext, TimerActivity::class.java)
        startActivity(timerIntent)
    }


}
