package com.app.alex.bax.views.exercise

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.app.alex.bax.R
import com.app.alex.bax.model.Exercise
import com.app.alex.bax.views.MainActivity
import kotlinx.android.synthetic.main.activity_new_exercise_success.*

class NewExerciseSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_exercise_success)
        showSuccessMessage()
        btn_back.setOnClickListener {
            backToMenu()
        }
    }

    private fun showSuccessMessage() {
        val exercise: Exercise = intent.getSerializableExtra("exercise") as Exercise
        success_text.text = "Exercise: ${exercise.name} has been added to your exercises list."
    }

    private fun backToMenu(){
        val mainMenuIntent: Intent = Intent(baseContext, MainActivity::class.java)
        startActivity(mainMenuIntent)

    }
}
