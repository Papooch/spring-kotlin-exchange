package cz.papooch.spring_kotlin_exchange.user

import javax.persistence.*

@Entity()
@Table(
    name = "users",
    indexes = [
        Index(name = "unique_name", columnList = "name", unique = true),
        Index(name = "unique_token", columnList = "token", unique = true)
    ]
)
class User(
    @Column(nullable = false)
    val name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    var id: Int = 0

    @Column(nullable = false)
    var token: String = ""
}
