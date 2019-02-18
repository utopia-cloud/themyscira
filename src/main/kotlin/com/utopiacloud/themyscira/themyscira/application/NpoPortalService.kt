package com.utopiacloud.themyscira.themyscira.application

import com.utopiacloud.themyscira.themyscira.helper.ZipHelper
import com.utopiacloud.themyscira.themyscira.interfaces.NpoPortalRestClient
import org.springframework.stereotype.Service

@Service
class NpoPortalService {

    private val npoPortalRestClient = NpoPortalRestClient()

    fun downloadZipHoujin() {
        val byteArray: ByteArray = npoPortalRestClient.getZipHoujin()!!
        ZipHelper.unzip(byteArray, "downloads")
    }

    fun downloadZipNpo() {
        val byteArray: ByteArray = npoPortalRestClient.getZipHoujin()!!
        ZipHelper.unzip(byteArray, "downloads")
    }
}