package com.app.alex.bax.views.exercise

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.alex.bax.R
import kotlinx.android.synthetic.main.activity_new_exercise.*

class NewExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_exercise)
        btn_create.setOnClickListener {
            launchSuccessCreateExerciseActivity()
        }
    }

    private fun launchSuccessCreateExerciseActivity() {
        val newExerciseIntent: Intent = Intent(baseContext, NewExerciseActivity::class.java)
        startActivity(newExerciseIntent)
    }


}
