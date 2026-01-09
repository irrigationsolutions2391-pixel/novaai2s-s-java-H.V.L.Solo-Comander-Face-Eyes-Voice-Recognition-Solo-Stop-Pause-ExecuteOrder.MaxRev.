// File generated from our OpenAPI spec by Stainless.

package com.configure_me_novaai2_jav.api.errors

import com.configure_me_novaai2_jav.api.core.JsonValue
import com.configure_me_novaai2_jav.api.core.http.Headers

abstract class Novaai2JavServiceException
protected constructor(message: String, cause: Throwable? = null) :
    Novaai2JavException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
