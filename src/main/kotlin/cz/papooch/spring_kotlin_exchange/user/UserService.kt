package cz.papooch.spring_kotlin_exchange.user

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service


@Service
class UserService (private val userRepository: UserRepository) : ApplicationRunner {


    override fun run(args: ApplicationArguments?) {
        // println("AAAAAAAAAAAAAAAAAAA")
    }

    fun createUser(name: String): User? {
        val user = User(name)
        val token = "token${Math.random().toString().substring(2)}"
        user.token = token
        try {
            userRepository.save(user)
        } catch (e: DataIntegrityViolationException) {
            println(e.message)
            return null
        }
        return user
    }

    fun getUserByToken(token: String): User? {
        return userRepository.findByToken(token)
    }
}