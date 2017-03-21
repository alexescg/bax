package com.app.alex.bax.api

import com.app.alex.bax.model.Exercise
import retrofit2.Call
import retrofit2.http.*

/**
 * Service that connects to api to handle exercises.
 *
 * @author alex
 * @since 3/20/17.
 */
interface ExerciseService {
    @GET("/exercises")
    fun getExercises(): Call<ListResponse<Exercise>>

    @GET("/exercises/{id}")
    fun getExerciseById(@Path("id") id: Int): Call<Exercise>

    @POST("/exercises")
    fun createExercise(@Body exercise : Exercise) : Call<Exercise>

    @DELETE("/exercises/{id}")
    fun deleteExerciseById(@Path("id") id: Int) : Call<Exercise>
}