package com.utopiacloud.themyscira.themyscira.application

import com.utopiacloud.themyscira.themyscira.interfaces.file.ZipHelper
import com.utopiacloud.themyscira.themyscira.interfaces.web.NpoPortalRestClient
import org.springframework.stereotype.Service

@Service
class NpoPortalService {

    private val npoPortalRestClient = NpoPortalRestClient()

    private val zipHelper = ZipHelper

    fun downloadZipHoujin() {
        val byteArray: ByteArray = npoPortalRestClient.getZipHoujin()!!
        zipHelper.unzip(byteArray, "downloads")
    }

    fun downloadZipNpo() {
        val byteArray: ByteArray = npoPortalRestClient.getZipHoujin()!!
        zipHelper.unzip(byteArray, "downloads")
    }
}