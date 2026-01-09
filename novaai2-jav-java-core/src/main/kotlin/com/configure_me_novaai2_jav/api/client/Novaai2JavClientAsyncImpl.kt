// File generated from our OpenAPI spec by Stainless.

package com.configure_me_novaai2_jav.api.client

import com.configure_me_novaai2_jav.api.core.ClientOptions
import com.configure_me_novaai2_jav.api.core.getPackageVersion
import com.configure_me_novaai2_jav.api.services.async.PetServiceAsync
import com.configure_me_novaai2_jav.api.services.async.PetServiceAsyncImpl
import com.configure_me_novaai2_jav.api.services.async.StoreServiceAsync
import com.configure_me_novaai2_jav.api.services.async.StoreServiceAsyncImpl
import com.configure_me_novaai2_jav.api.services.async.UserServiceAsync
import com.configure_me_novaai2_jav.api.services.async.UserServiceAsyncImpl
import java.util.function.Consumer

class Novaai2JavClientAsyncImpl(private val clientOptions: ClientOptions) : Novaai2JavClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: Novaai2JavClient by lazy { Novaai2JavClientImpl(clientOptions) }

    private val withRawResponse: Novaai2JavClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetServiceAsync by lazy { PetServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val store: StoreServiceAsync by lazy {
        StoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): Novaai2JavClient = sync

    override fun withRawResponse(): Novaai2JavClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): Novaai2JavClientAsync =
        Novaai2JavClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun pets(): PetServiceAsync = pets

    override fun store(): StoreServiceAsync = store

    override fun users(): UserServiceAsync = users

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        Novaai2JavClientAsync.WithRawResponse {

        private val pets: PetServiceAsync.WithRawResponse by lazy {
            PetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreServiceAsync.WithRawResponse by lazy {
            StoreServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): Novaai2JavClientAsync.WithRawResponse =
            Novaai2JavClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pets(): PetServiceAsync.WithRawResponse = pets

        override fun store(): StoreServiceAsync.WithRawResponse = store

        override fun users(): UserServiceAsync.WithRawResponse = users
    }
}
