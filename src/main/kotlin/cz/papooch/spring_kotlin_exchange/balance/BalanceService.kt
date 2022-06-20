package cz.papooch.spring_kotlin_exchange.balance

import cz.papooch.spring_kotlin_exchange.user.User
import org.springframework.stereotype.Service
import java.math.BigDecimal
import javax.transaction.Transactional

@Service
@Transactional
class BalanceService (
    private val balanceRepository: BalanceRepository,
) {
    fun createForUser(user: User): Balance {
        val balance = Balance(user)
        balanceRepository.save(balance)
        return balance
    }

    fun setForUser(user: User, currency: Currency, amount: BigDecimal): Balance? {
        val balance = balanceRepository.findByUserId(user.id) ?: createForUser(user)

        when (currency) {
            Currency.BTC -> balance.BTC = amount
            Currency.USD -> balance.USD = amount
        }

        return balance
    }

    fun getForUser(user: User): Balance {
        return balanceRepository.findByUserId(user.id) ?: createForUser(user)
    }
}
