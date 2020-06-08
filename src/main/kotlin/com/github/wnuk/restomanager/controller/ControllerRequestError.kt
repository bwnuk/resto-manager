package com.github.wnuk.restomanager.controller

import com.github.wnuk.restomanager.exception.CustomException
import com.github.wnuk.restomanager.model.ErrorsDetails
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class ControllerRequestError: ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [(CustomException::class)])
    fun handleUserAlreadyExists(ex: CustomException,request: WebRequest): ResponseEntity<ErrorsDetails> {
        val errorDetails = ErrorsDetails(Date(),
                "Validation Failed",
                ex.message!!
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
}