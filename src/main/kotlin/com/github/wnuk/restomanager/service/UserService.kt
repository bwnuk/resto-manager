package com.github.wnuk.restomanager.service

import com.github.wnuk.restomanager.dto.UserDto

interface UserService {
    fun deleteUser(id: Long)

    fun createUser(user: UserDto): UserDto?

    fun getUser(id: Long): UserDto?

    fun getAllUsers(): List<UserDto>
}