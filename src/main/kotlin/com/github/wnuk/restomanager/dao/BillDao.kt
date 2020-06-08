package com.github.wnuk.restomanager.dao

import com.github.wnuk.restomanager.dto.BillDto
import javax.persistence.*

@Entity
@Table
data class BillDao(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column
        val tableId: Long,
        @Column
        var sum: Double,
        @ManyToOne(fetch = FetchType.EAGER)
        val user: UserDao
)

fun BillDao.toBillDto() = BillDto(
        id,
        tableId,
        sum = sum,
        user = user.id
)