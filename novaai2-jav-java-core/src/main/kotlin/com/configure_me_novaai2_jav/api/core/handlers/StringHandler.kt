@file:JvmName("StringHandler")

package com.configure_me_novaai2_jav.api.core.handlers

import com.configure_me_novaai2_jav.api.core.http.HttpResponse
import com.configure_me_novaai2_jav.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
