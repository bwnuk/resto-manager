package com.github.wnuk.restomanager.repository

import com.github.wnuk.restomanager.dao.BillDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BillRepository : JpaRepository<BillDao, Long> {
}