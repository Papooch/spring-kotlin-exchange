package cz.papooch.spring_kotlin_exchange.balance

import cz.papooch.spring_kotlin_exchange.user.User
import java.math.BigDecimal
import javax.persistence.*

@Entity()
@Table(
    name = "balances"
)
class Balance(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    var id: Int,

    @Column()
    var USD: BigDecimal = BigDecimal.ZERO,

    @Column()
    var BTC: BigDecimal = BigDecimal.ZERO
) {
    @OneToOne()
    @JoinColumn(foreignKey = ForeignKey(name = "fk_balance_user_id"))
    var user: User? = null
}
