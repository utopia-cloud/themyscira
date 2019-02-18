package com.utopiacloud.themyscira.themyscira.helper

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

object ZipHelper {
    private const val BUFFER_SIZE = 4096

    @Throws(IOException::class)
    fun unzip(data: ByteArray, dirName: String) {
        val destDir = File(dirName)
        if (!destDir.exists()) {
            destDir.mkdir()
        }
        val zipIn = ZipInputStream(ByteArrayInputStream(data))
        var entry: ZipEntry? = zipIn.nextEntry

        while (entry != null) {
            val filePath = dirName + File.separator + entry.name
            if (!entry.isDirectory) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath)
            } else {
                // if the entry is a directory, make the directory
                val dir = File(filePath)
                dir.mkdir()
            }
            zipIn.closeEntry()
            entry = zipIn.nextEntry
        }
        zipIn.close()
    }

    @Throws(IOException::class)
    private fun extractFile(zipIn: ZipInputStream, filePath: String) {
        val bos = BufferedOutputStream(FileOutputStream(filePath))
        val bytesIn = ByteArray(BUFFER_SIZE)
        var read: Int
        do {
            read = zipIn.read(bytesIn)
            if (read == -1) {
                break
            }
            bos.write(bytesIn, 0, read)
        } while (true)
        bos.close()
    }
}