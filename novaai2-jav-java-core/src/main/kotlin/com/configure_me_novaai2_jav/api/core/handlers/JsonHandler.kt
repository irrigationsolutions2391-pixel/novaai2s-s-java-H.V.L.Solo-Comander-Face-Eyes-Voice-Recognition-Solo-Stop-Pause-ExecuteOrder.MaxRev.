@file:JvmName("JsonHandler")

package com.configure_me_novaai2_jav.api.core.handlers

import com.configure_me_novaai2_jav.api.core.http.HttpResponse
import com.configure_me_novaai2_jav.api.core.http.HttpResponse.Handler
import com.configure_me_novaai2_jav.api.errors.Novaai2JavInvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw Novaai2JavInvalidDataException("Error reading response", e)
            }
    }
