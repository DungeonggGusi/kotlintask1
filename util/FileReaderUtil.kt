package ru.dungeongg.kotlintask1.util

import java.io.File
import java.nio.charset.Charset

object FileReaderUtil {

    /**
     * Считывает содержимое файла с указанной кодировкой в строку.
     */
    fun readFileWithEncoding(file: File, encoding: String): String {
        val charset = Charset.forName(encoding)
        return file.readText(charset)
    }
}
