package com.app.alex.bax.views.exercise

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.AdapterView
import com.app.alex.bax.R
import com.app.alex.bax.api.ListResponse
import com.app.alex.bax.api.RestClient
import com.app.alex.bax.model.Exercise
import kotlinx.android.synthetic.main.content_exercise.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            createExerciseIntent()
        }
        populateList()
        list_exercises.isLongClickable = true
        list_exercises.setOnItemLongClickListener {
            parent, view, position, id ->
            TODO("implement delete")
            // true
        }
    }

    private fun createExerciseIntent() {
        val newExerciseIntent: Intent = Intent(baseContext, NewExerciseActivity::class.java)
        startActivity(newExerciseIntent)
    }

    private fun populateList() {
        val client: RestClient = RestClient()
        val call: Call<ListResponse<Exercise>> = client.getExercises()
        call.enqueue(object : Callback<ListResponse<Exercise>> {
            override fun onResponse(call: Call<ListResponse<Exercise>>?, response: Response<ListResponse<Exercise>>?) {
                if (response!!.isSuccessful) {
                    list_exercises.adapter = ExerciseListAdapter(response.body().items, baseContext)
                } else {
                    list_exercises.adapter = ExerciseListAdapter(emptyList<Exercise>(), baseContext)
                }
            }

            override fun onFailure(call: Call<ListResponse<Exercise>>?, t: Throwable?) {
                Log.d("failure /exercises", t.toString())
            }

        })
    }

}
