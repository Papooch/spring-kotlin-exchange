package cz.papooch.spring_kotlin_exchange.auth

import cz.papooch.spring_kotlin_exchange.annotations.IsPublic
import cz.papooch.spring_kotlin_exchange.balance.BalanceService
import cz.papooch.spring_kotlin_exchange.user.User
import cz.papooch.spring_kotlin_exchange.user.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@Tag(
    name = "Authentication",
    description = "Endpoints for authenticating the user"
)
@RestController
class AuthController(
    private val userService: UserService,
    private val balanceService: BalanceService,
) {

    @IsPublic
    @Operation(
        summary = "Create a new user",
        description = "To register a new user, send a username in the body. " +
                "Returns an access token that must be used in the Authorization header of other API calls",
    )
    @PostMapping(
        "/register",
        produces = ["application/json"],
        consumes = ["text/plain"],
    )
    fun register(@RequestBody(required = true) name: String): User? {
        val user = userService.createUser(name)
        if (user === null) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "User with the name already exists")
        }
        balanceService.createForUser(user)
        return user
    }
}