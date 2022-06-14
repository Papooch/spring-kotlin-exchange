package cz.papooch.spring_kotlin_exchange.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun findByToken(token: String): User?
}