package com.github.wnuk.restomanager.dao

import com.github.wnuk.restomanager.dto.BillDto
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table
data class BillDao(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @get: NotBlank
        val tableId: Long,
        @OneToMany
        @get: NotBlank
        val dishes: List<DishDao>,
        @get: NotBlank
        var sum: Double,
        @ManyToOne
        @get: NotBlank
        val user: UserDao
)

fun BillDao.toBillDto() = BillDto(
        id,
        tableId,
        dishes = dishes.map { it.toDishDto() },
        sum = sum,
        user = user.toUserDto()
)