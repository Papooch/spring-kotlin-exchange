package cz.papooch.spring_kotlin_exchange.order

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StandingOrderRepository : JpaRepository<StandingOrder, UUID> {
}