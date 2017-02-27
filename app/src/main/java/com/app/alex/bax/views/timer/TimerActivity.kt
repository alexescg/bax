package com.app.alex.bax.views.timer

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.NotificationCompat
import android.util.Log
import com.app.alex.bax.R
import kotlinx.android.synthetic.main.activity_timer.*
import java.util.*


class TimerActivity : AppCompatActivity() {
    private val millisPerMinute: Long = 60000L
    private val millisPerSecond: Long = 1000L
    private var timeLeft: Long = 0L
    private val timerHandler: Handler = Handler()
    private val timerRunnable = object : Runnable {
        override fun run() {
            if (this@TimerActivity.timeLeft >= 0L) {
                text_timeLeft.text = formatMinSecFromMillis(this@TimerActivity.timeLeft)
                this@TimerActivity.timeLeft -= 1000L
                timerHandler.postDelayed(this, millisPerSecond)
            } else {
                onPause()
                buildNotification()
            }
        }
    }

    private fun buildNotification() {
        val builder = NotificationCompat.Builder(baseContext)
                .setSmallIcon(R.drawable.ic_box_glove)
                .setContentTitle("Bax")
                .setContentText("Round finished!")
        val notificationId = Random().nextInt()
        val targetIntent = Intent(baseContext, TimerActivity::class.java)
        val contentIntent = PendingIntent.getActivity(baseContext, 0, targetIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setContentIntent(contentIntent)
        val nManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.notify(notificationId, builder.build())
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        v.vibrate(200)
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
        btn_start.text = resources.getString(R.string.start)
    }

    private fun initComponents() {
        initRoundTimeSeekBar()
//        initRestTimeSeekBar()
        initStartButton()
    }

    private fun initStartButton() {
        btn_start.setOnClickListener({ v ->
            if (btn_start.text.equals("Stop")) {
                timerHandler.removeCallbacks(timerRunnable)
                btn_start.text = resources.getString(R.string.start)
            } else {
                timeLeft = seek_roundTime.progress * millisPerMinute
                timerHandler.postDelayed(timerRunnable, 0)
                btn_start.text = resources.getString(R.string.stop)
            }
        })
    }

//    private fun initRestTimeSeekBar() {
//        seek_restTime.setOnSeekBarChangeListener(RestTimeSeekBarListener(text_restTime))
//    }

    private fun initRoundTimeSeekBar() {
        seek_roundTime.setOnSeekBarChangeListener(RoundTimeSeekBarListener(text_roundTime))
    }


}
