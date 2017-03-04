package com.app.alex.bax.views.exercise

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.app.alex.bax.R
import com.app.alex.bax.model.Exercise
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
        val exerciseName: Editable = text_name.text
        val exerciseAbout: Editable = text_name.text
        if (exerciseName.isNotEmpty() && exerciseAbout.isNotEmpty()) {
            val newExercise: Exercise = Exercise(exerciseName.toString(), exerciseAbout.toString())
            Exercises.exerciseList.add(newExercise)
            val newExerciseSuccessIntent: Intent = Intent(baseContext, NewExerciseSuccessActivity::class.java)
            newExerciseSuccessIntent.putExtra("exercise", newExercise)
            startActivity(newExerciseSuccessIntent)
        } else {
            Toast.makeText(baseContext, "A field is empty", Toast.LENGTH_SHORT).show()
        }


    }


}
