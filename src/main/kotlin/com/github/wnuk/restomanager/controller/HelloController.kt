package com.github.wnuk.restomanager.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController{

    @GetMapping("/hello")
    fun helloKotlin(): ResponseEntity<String>{
        return ResponseEntity.ok("Hello World")
    }
}