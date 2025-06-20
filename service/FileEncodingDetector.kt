package ru.dungeongg.kotlintask1.service

import org.mozilla.universalchardet.UniversalDetector
import java.io.File
import java.io.FileInputStream

class FileEncodingDetector {

    /**
     * Определяет кодировку файла с помощью библиотеки juniversalchardet (Mozilla Universal Charset Detector).
     */
    fun detectEncoding(file: File): String {
        val buffer = ByteArray(4096)
        val detector = UniversalDetector(null)

        FileInputStream(file).use { fis ->
            var nread: Int
            while (fis.read(buffer).also { nread = it } > 0 && !detector.isDone) {
                detector.handleData(buffer, 0, nread)
            }
        }
        detector.dataEnd()

        return detector.detectedCharset ?: "UTF-8" // по умолчанию UTF-8
    }
}
