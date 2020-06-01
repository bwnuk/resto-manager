package com.github.wnuk.restomanager.service

import com.github.wnuk.restomanager.dto.BillDto

interface BillService {
    fun addBill(bill: BillDto): BillDto
    fun getBillById(id: Long): BillDto
    fun getBills(): List<BillDto>
}