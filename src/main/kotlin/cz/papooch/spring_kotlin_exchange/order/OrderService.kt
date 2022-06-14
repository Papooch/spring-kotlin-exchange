package cz.papooch.spring_kotlin_exchange.order

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Service

@Service
class OrderService (private val standingOrderRepository: StandingOrderRepository): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val standingOrder = StandingOrder()
        standingOrderRepository.save(standingOrder)
    }
}