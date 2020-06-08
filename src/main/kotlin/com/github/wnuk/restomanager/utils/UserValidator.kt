package com.github.wnuk.restomanager.utils

import com.github.wnuk.restomanager.exception.CustomException

class UserValidator {
    companion object{
        fun checkPassword(password: String): Boolean{
            val PATTERN: String = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"

            if (password.length <= 8 ){
                throw CustomException("PASSWORD TOO SHORT")
            } else if (password.matches(Regex(PATTERN))){
                return true
            }

            throw CustomException("ADD MORE SYMBOLS AND CAPITAL LETTERS")

        }

        fun checkUpperCase(lastname: String): Boolean{
            if(lastname.get(0).isLowerCase()){
                throw CustomException("UpperCase")
            }
            return true
        }
    }
}