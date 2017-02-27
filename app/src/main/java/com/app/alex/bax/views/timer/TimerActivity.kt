package com.app.alex.bax.views.timer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import com.app.alex.bax.R
import kotlinx.android.synthetic.main.activity_timer.*


class TimerActivity : AppCompatActivity() {
    private val millisPerMinute: Long = 60000L
    private val millisPerSecond: Long = 1000L
    private val timerHandler: Handler = Handler()
    private var timeLeft: Long = 0L
    private val timerRunnable = object : Runnable {
        override fun run() {
            this@TimerActivity.timeLeft = seek_roundTime.progress * millisPerMinute
            text_timeLeft.text = formatMinSecFromMillis(this@TimerActivity.timeLeft)
            this@TimerActivity.timeLeft -= 1000L
            Log.d("hue", this@TimerActivity.timeLeft.toString())
            timerHandler.postDelayed(this, millisPerSecond)
        }

    }

    private fun formatMinSecFromMillis(timeLeft: Long): String {
        val minutesLeft: Long = timeLeft / 60000
        val secondsLeft: Long = (timeLeft - (minutesLeft * 60000)) / millisPerSecond
        Log.d("time", "$minutesLeft : $secondsLeft")
        return "$minutesLeft : $secondsLeft"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        initComponents()

    }

    override fun onPause() {
        super.onPause()
        timerHandler.removeCallbacks(timerRunnable)
        btn_start.text = btn_start.resources.getString(R.string.start)
    }

    private fun initComponents() {
        initRoundTimeSeekBar()
        initRestTimeSeekBar()
        initStartButton()
    }

    private fun initStartButton() {
        btn_start.setOnClickListener({ v ->

            if (btn_start.getText().equals("Stop")) {
                timerHandler.removeCallbacks(timerRunnable)
                btn_start.text = resources.getString(R.string.start)
            } else {
                timerHandler.postDelayed(timerRunnable, 0)
                btn_start.resources.getString(R.string.stop)
            }
        })
    }

    private fun initRestTimeSeekBar() {
        seek_restTime.setOnSeekBarChangeListener(RestTimeSeekBarListener(text_restTime))
    }

    private fun initRoundTimeSeekBar() {
        seek_roundTime.setOnSeekBarChangeListener(RoundTimeSeekBarListener(text_roundTime))
    }


}
