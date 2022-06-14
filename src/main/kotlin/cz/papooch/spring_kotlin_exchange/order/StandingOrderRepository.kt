package cz.papooch.spring_kotlin_exchange.order

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StandingOrderRepository : JpaRepository<StandingOrder, UUID> {
}