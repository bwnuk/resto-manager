package com.github.wnuk.restomanager.service.impl

import com.github.wnuk.restomanager.dao.toUserDto
import com.github.wnuk.restomanager.dto.UserDto
import com.github.wnuk.restomanager.dto.toUserDao
import com.github.wnuk.restomanager.repository.UserRepository
import com.github.wnuk.restomanager.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val repository: UserRepository): UserService {
    private val log = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun deleteUser(id: Long) {
        repository.deleteById(id)

    }

    override fun createUser(user: UserDto): UserDto {
        if (repository.findAllByUsername(user.username).isNullOrEmpty()){
        }

        val userDao = user.toUserDao()
        repository.save(userDao)

        return userDao.toUserDto()
    }

    override fun getUser(id: Long): UserDto? {
        val user = repository.findById(id)
        user.let {
            return it.get().toUserDto()
        }
    }

    override fun getAllUsers(): List<UserDto> {
        return repository.findAll().map { it.toUserDto() }
    }
}