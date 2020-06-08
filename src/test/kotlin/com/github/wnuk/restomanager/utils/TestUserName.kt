package com.github.wnuk.restomanager.utils

import com.github.wnuk.restomanager.exception.CustomException
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestUserName {
    @Test(expected = CustomException::class)
    fun notUpperCase(){
        UserValidator.checkUpperCase("aaa")
    }
}