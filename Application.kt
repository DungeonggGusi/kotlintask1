package ru.dungeongg.kotlintask1

import ru.dungeongg.kotlintask1.service.FileEncodingDetector
import ru.dungeongg.kotlintask1.util.FileReaderUtil
import java.io.File

fun main() {
    val filePath = "src/main/resources/sample.txt" // путь к вашему файлу
    val file = File(filePath)

    if (!file.exists()) {
        println("Файл не найден: $filePath")
        return
    }

    val detector = FileEncodingDetector()
    val encoding = detector.detectEncoding(file)
    println("Определённая кодировка файла: $encoding")

    val content = FileReaderUtil.readFileWithEncoding(file, encoding)
    println("Содержимое файла:")
    println(content)
}
