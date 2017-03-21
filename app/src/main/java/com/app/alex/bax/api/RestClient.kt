package com.app.alex.bax.api

import com.app.alex.bax.model.Exercise
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 *
 *
 * @author alex
 * @since 3/20/17.
 */
class RestClient() {
    companion object {
        private val baseUrl: String = "192.168.1.92:4000"
        private var retrofit: Retrofit

        init {
            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(
                            JacksonConverterFactory.create())
                    .build()
        }
    }

    val exerciseService: ExerciseService

    init {
        exerciseService = retrofit.create(ExerciseService::class.java)
    }

    fun getExercises(): Call<List<Exercise>> {
        return exerciseService.getExercises()
    }
}