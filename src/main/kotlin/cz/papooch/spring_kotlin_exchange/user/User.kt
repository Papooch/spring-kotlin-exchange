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
class User() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Access(AccessType.PROPERTY)
    var id: Int = 0

    @Column(nullable = false)
    var name: String = ""

    @Column(nullable = false)
    var token: String = ""

    constructor(name: String, token: String = ""): this() {
        this.name = name
        this.token = token
    }

}
