package com.app.alex.bax.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.alex.bax.R
import com.app.alex.bax.views.exercise.ExerciseActivity
import com.app.alex.bax.views.info.AttackListActivity
import com.app.alex.bax.views.timer.TimerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        btn_timer.setOnClickListener {
            createTimerIntent()
        }
        btn_info.setOnClickListener {
            createInfoIntent()
        }
        btn_exercises.setOnClickListener {
            createExerciseIntent()
        }
    }

    private fun createTimerIntent() {
        val timerIntent: Intent = Intent(baseContext, TimerActivity::class.java)
        startActivity(timerIntent)
    }

    private fun createInfoIntent() {
        val attackListIntent: Intent = Intent(baseContext, AttackListActivity::class.java)
        startActivity(attackListIntent)
    }

    private fun createExerciseIntent() {
        val exerciseIntent: Intent = Intent(baseContext, ExerciseActivity::class.java)
        startActivity(exerciseIntent)
    }
}
