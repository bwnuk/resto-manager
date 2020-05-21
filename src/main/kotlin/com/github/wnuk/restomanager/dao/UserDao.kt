package com.github.wnuk.restomanager.dao

import com.github.wnuk.restomanager.dto.UserDto
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table
data class UserDao(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        @get: NotBlank
        val username: String = "",
        @get: NotBlank
        val firstname: String = "",
        @get: NotBlank
        val lastname: String = "",
        @get: NotBlank
        val password: String = "",
        @get: NotBlank
        val role: String = ROLE.WAITER.toString()
)


enum class ROLE{
    MANAGER,
    CHEF,
    WAITER
}

fun UserDao.toUserDto() = UserDto(
        id = id,
        username = username,
        firstname = firstname,
        lastname = lastname,
        password = password,
        role = ROLE.valueOf(role)
)
