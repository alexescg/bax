package com.app.alex.bax

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        initComponents()
    }

    private fun initComponents() {
        initRoundTimeSeekBar()
        initRestTimeSeekBar()

    }

    private fun initRestTimeSeekBar() {
        seek_restTime.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                text_restTime.text = "$progress s"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Just an empty method
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Another empty method
            }
        })
    }

    private fun initRoundTimeSeekBar() {
        seek_roundTime.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                text_roundTime.text = "$progress min"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Just an empty method
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Another empty method
            }
        })
    }
}
