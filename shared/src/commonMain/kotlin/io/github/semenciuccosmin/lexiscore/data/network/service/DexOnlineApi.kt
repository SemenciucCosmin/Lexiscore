package io.github.semenciuccosmin.lexiscore.data.network.service

import io.github.semenciuccosmin.lexiscore.data.network.model.Resource
import io.github.semenciuccosmin.lexiscore.data.network.model.processApiResource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class DexOnlineApi(private val httpClient: HttpClient) {

    suspend fun getWordDefinition(word: String): Resource<String> {
        return processApiResource {
            httpClient.get("https://dexonline.ro/definitie/$word")
        }
    }
}