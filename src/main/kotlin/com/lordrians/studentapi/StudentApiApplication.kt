package com.lordrians.studentapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudentApiApplication

fun main(args: Array<String>) {
    runApplication<StudentApiApplication>(*args)
}
