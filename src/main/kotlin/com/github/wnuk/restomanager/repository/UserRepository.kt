package com.github.wnuk.restomanager.repository

import com.github.wnuk.restomanager.dao.UserDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<UserDao, Long> {
    fun findAllByFirstname(name: String): MutableList<UserDao>?
    fun findAllByUsername(name: String): MutableList<UserDao>?
    override fun findById(id: Long): Optional<UserDao>
    override fun deleteById(id: Long)
}