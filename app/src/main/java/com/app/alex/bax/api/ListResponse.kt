package com.app.alex.bax.api

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *
 *
 * @author alex
 * @since 3/20/17.
 */
data class ListResponse<T>(@JsonProperty("data") var items: List<T>) {

}