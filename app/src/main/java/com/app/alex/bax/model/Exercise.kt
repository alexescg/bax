package com.app.alex.bax.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import java.io.Serializable

/**
 *
 *
 * @author alex
 * @since 2/28/17.
 */
data class Exercise(@JsonProperty(value = "id") val id: Int,
                    @JsonProperty(value = "name") var name: String,
                    @JsonProperty(value = "description") var description: String
) : Serializable