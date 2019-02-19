package com.utopiacloud.themyscira.themyscira.interfaces.web

import org.springframework.web.client.RestTemplate

class NpoPortalRestClient {
    private val baseUrl: String = "https://www.npo-homepage.go.jp/npoportal"

    private val restTemplate: RestTemplate = RestTemplate()

    fun getZip(uri: String): ByteArray? {
        return restTemplate.getForObject("$baseUrl$uri", ByteArray::class.java)
    }

    fun getZipGyousei(): ByteArray? {
        return this.getZip(uri = "/download/zip/gyousei_000.zip")
    }

    fun getZipHoujin(): ByteArray? {
        return this.getZip(uri = "/download/zip/houjin_000.zip")
    }
}