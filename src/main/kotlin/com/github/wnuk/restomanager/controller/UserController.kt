package com.github.wnuk.restomanager.controller

import com.github.wnuk.restomanager.dto.UserDto
import com.github.wnuk.restomanager.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private var service: UserService) {

    @PostMapping("/register")
    fun createUser(@RequestBody user: UserDto): ResponseEntity<UserDto> = ResponseEntity.accepted().body(service.createUser(user))


    @DeleteMapping("/delete")
    fun deleteUser(@RequestParam id: Long): ResponseEntity<String>  {
        service.deleteUser(id)
        return ResponseEntity.accepted().body("AA")
    }

    @GetMapping("")
    fun getUser(@RequestParam id: Long): ResponseEntity<UserDto> = ResponseEntity.ok().body(service.getUserId(id))

    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<List<UserDto>> = ResponseEntity.ok().body(service.getAllUsers())

}