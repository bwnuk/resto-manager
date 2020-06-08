package com.github.wnuk.restomanager.utils

import com.github.wnuk.restomanager.exception.CustomException
import junit.framework.Assert
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestPasswordUtils {
    @Test
    fun correctPassword(){
        Assert.assertEquals(UserValidator.checkPassword("!TestowanieH4sl!@#"), true)
    }

    @Test(expected = CustomException::class)
    fun tooShortPassword(){
        UserValidator.checkPassword("13")
    }

    @Test(expected = CustomException::class)
    fun notComplicatedPassword(){
        UserValidator.checkPassword("TestowanieHasla")
    }
}