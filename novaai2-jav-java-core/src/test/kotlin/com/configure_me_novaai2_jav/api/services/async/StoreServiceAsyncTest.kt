// File generated from our OpenAPI spec by Stainless.

package com.configure_me_novaai2_jav.api.services.async

import com.configure_me_novaai2_jav.api.TestServerExtension
import com.configure_me_novaai2_jav.api.client.okhttp.Novaai2JavOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StoreServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun listInventory() {
        val client =
            Novaai2JavOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val storeServiceAsync = client.store()

        val responseFuture = storeServiceAsync.listInventory()

        val response = responseFuture.get()
        response.validate()
    }
}
