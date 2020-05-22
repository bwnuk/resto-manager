package com.github.wnuk.restomanager.service

import com.github.wnuk.restomanager.dto.UserDto

interface UserService {
    fun deleteUser(id: Long)

    fun createUser(user: UserDto): UserDto?

    fun getUserId(id: Long): UserDto?

    fun getAllUsers(): List<UserDto>

    fun getUserByUsername(username: String): UserDto?
}