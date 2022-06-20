package cz.papooch.spring_kotlin_exchange.order

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders")
class StandingOrder {
    @Id
    @Column(name = "id", nullable = false)
    var id: UUID = UUID.randomUUID()

    @Column
    @Enumerated(EnumType.STRING)
    var type: StandingOrderType = StandingOrderType.BUY
}