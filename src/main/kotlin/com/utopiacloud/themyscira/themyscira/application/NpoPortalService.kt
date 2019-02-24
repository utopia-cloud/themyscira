package com.utopiacloud.themyscira.themyscira.application

import com.utopiacloud.themyscira.themyscira.interfaces.file.FileHelper
import com.utopiacloud.themyscira.themyscira.interfaces.web.NpoPortalRestClient
import org.springframework.stereotype.Service

@Service
class NpoPortalService {

    private val npoPortalRestClient = NpoPortalRestClient()

    private val fileHelper = FileHelper

    fun downloadZipCorporate(fileName: String) {
        val byteArray: ByteArray = npoPortalRestClient.getZipCorporate()!!
        val path = fileHelper.unzip(byteArray, "downloads")
        if (fileName.isEmpty()) {
            return
        }
        fileHelper.rename(
                pathStr = path,
                renameTo = "downloads/$fileName"
        )
    }

    fun downloadZipAdministrative(fileName: String) {
        val byteArray: ByteArray = npoPortalRestClient.getZipAdministrative()!!
        val path = fileHelper.unzip(byteArray, "downloads")
        if (fileName.isEmpty()) {
            return
        }
        fileHelper.rename(
                pathStr = path,
                renameTo = "downloads/$fileName"
        )
    }
}