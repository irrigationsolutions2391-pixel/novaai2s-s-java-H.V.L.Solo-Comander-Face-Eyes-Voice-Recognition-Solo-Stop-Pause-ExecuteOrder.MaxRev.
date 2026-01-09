// File generated from our OpenAPI spec by Stainless.

package com.configure_me_novaai2_jav.api.services.blocking

import com.configure_me_novaai2_jav.api.TestServerExtension
import com.configure_me_novaai2_jav.api.client.okhttp.Novaai2JavOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StoreServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun listInventory() {
        val client =
            Novaai2JavOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val storeService = client.store()

        val response = storeService.listInventory()

        response.validate()
    }
}
