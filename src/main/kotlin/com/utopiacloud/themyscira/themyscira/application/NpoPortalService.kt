package com.utopiacloud.themyscira.themyscira.application

import com.utopiacloud.themyscira.themyscira.interfaces.file.ZipHelper
import com.utopiacloud.themyscira.themyscira.interfaces.web.NpoPortalRestClient
import org.springframework.stereotype.Service

@Service
class NpoPortalService {

    private val npoPortalRestClient = NpoPortalRestClient()

    private val zipHelper = ZipHelper

    fun downloadZipCorporate() {
        val byteArray: ByteArray = npoPortalRestClient.getZipCorporate()!!
        zipHelper.unzip(byteArray, "downloads")
    }

    fun downloadZipAdministrative() {
        val byteArray: ByteArray = npoPortalRestClient.getZipAdministrative()!!
        zipHelper.unzip(byteArray, "downloads")
    }
}