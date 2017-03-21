package com.app.alex.bax.views.exercise

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.app.alex.bax.R
import com.app.alex.bax.api.ListResponse
import com.app.alex.bax.api.RestClient
import com.app.alex.bax.model.Exercise
import kotlinx.android.synthetic.main.activity_new_exercise.*
import kotlinx.android.synthetic.main.content_exercise.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val exerciseAbout: Editable = text_about.text
        if (exerciseName.isNotEmpty() && exerciseAbout.isNotEmpty()) {
            val newExercise: Exercise = Exercise(1, exerciseName.toString(), exerciseAbout.toString())
            createExerciseRequest(newExercise)

            val newExerciseSuccessIntent: Intent = Intent(baseContext, NewExerciseSuccessActivity::class.java)
            startActivity(newExerciseSuccessIntent)
            Toast.makeText(baseContext, "Exercise created successfully!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(baseContext, "A field is empty", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createExerciseRequest(exercise: Exercise) {
        val client: RestClient = RestClient()
        val call = client.createExercise(exercise)
        call.enqueue(object : Callback<Exercise> {
            override fun onFailure(call: Call<Exercise>?, t: Throwable?) {
                Log.d("Error post /exercises :", t.toString())
            }

            override fun onResponse(call: Call<Exercise>?, response: Response<Exercise>?) {
                if (!response!!.isSuccessful){

                }
            }
        });

    }


}
