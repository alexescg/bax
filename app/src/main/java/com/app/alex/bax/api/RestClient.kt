package com.app.alex.bax.api

import com.app.alex.bax.model.Exercise
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 *
 *
 * @author alex
 * @since 3/20/17.
 */
class RestClient {
    companion object {
        private val baseUrl: String = "http://192.168.1.92:4000"
        private var retrofit: Retrofit

        init {
            val kotlinMapper = ObjectMapper().registerModule(KotlinModule())
//                    .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(
                            JacksonConverterFactory.create(kotlinMapper))
                    .build()
        }
    }

    private val exerciseService: ExerciseService

    init {
        exerciseService = retrofit.create(ExerciseService::class.java)
    }

    fun getExercises(): Call<ListResponse<Exercise>> {
        return exerciseService.getExercises()
    }

    fun createExercise(exercise: Exercise): Call<Exercise> {
        return exerciseService.createExercise(exercise)
    }
}