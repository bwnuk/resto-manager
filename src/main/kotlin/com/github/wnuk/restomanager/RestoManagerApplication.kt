package com.github.wnuk.restomanager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestoManagerApplication

fun main(args: Array<String>) {
    SpringApplication.run(RestoManagerApplication::class.java, *args)
}
