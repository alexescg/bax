package com.app.alex.bax.views.exercise

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.BaseAdapter

import com.app.alex.bax.R
import kotlinx.android.synthetic.main.content_exercise.*

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
        list_exercises.adapter = ExerciseListAdapter(Exercises.exerciseList, baseContext)
    }

    private fun createExerciseIntent() {
        val newExerciseIntent: Intent = Intent(baseContext, NewExerciseActivity::class.java)
        startActivity(newExerciseIntent)
    }
}
