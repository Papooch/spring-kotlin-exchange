package cz.papooch.spring_kotlin_exchange.balance

import org.springframework.data.jpa.repository.JpaRepository

interface BalanceRepository : JpaRepository<Balance, Int> {
    fun findByUserId(userId: Int): Balance?
}