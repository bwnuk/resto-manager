package com.github.wnuk.restomanager.service.impl

import com.github.wnuk.restomanager.dao.toBillDto
import com.github.wnuk.restomanager.dto.BillDto
import com.github.wnuk.restomanager.dto.toBillDao
import com.github.wnuk.restomanager.exception.CustomException
import com.github.wnuk.restomanager.repository.BillRepository
import com.github.wnuk.restomanager.repository.DishRepository
import com.github.wnuk.restomanager.repository.UserRepository
import com.github.wnuk.restomanager.service.BillService
import org.springframework.stereotype.Service

@Service
class BillServiceImpl(private val repository: BillRepository,
                      private val userRepository: UserRepository) : BillService {
    override fun addBill(bill: BillDto): BillDto {
        val userDao = userRepository.findById(bill.user).get()
        val billDao = bill.toBillDao(userDao)
        repository.save(billDao)
        return billDao.toBillDto()
    }

    override fun getBillById(id: Long): BillDto {
        val bill = repository.findById(id)
        if (bill.isEmpty){
            throw CustomException("Reservation Not Found")
        }
        return bill.get().toBillDto()
    }

    override fun getBills(): List<BillDto> {
        return repository.findAll().map { it.toBillDto() }.ifEmpty { throw CustomException("Reservation Not Found") }
    }
}