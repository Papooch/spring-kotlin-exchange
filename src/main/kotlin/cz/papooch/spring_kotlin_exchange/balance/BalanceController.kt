package cz.papooch.spring_kotlin_exchange.balance

import cz.papooch.spring_kotlin_exchange.request_context.RequestContext
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.format.annotation.NumberFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class SetBalanceDto(
    @field:NotEmpty
    @field:NotNull
    @field:NumberFormat(style = NumberFormat.Style.CURRENCY)
    val topup_amount: Int,

    @field:NotEmpty
    @field:NotNull
    val currency: Currency
)

data class BalanceDto(
    val BTC: BigDecimal,
    val USD: BigDecimal,
    val USD_equivalent: Int,
)

@Tag(
    name = "Balance"
)
@RestController
@RequestMapping("/balance")
class BalanceController(
    private val balanceService: BalanceService,
    private val requestContext: RequestContext
) {

    @PostMapping
    fun setBalance(@RequestBody(required = true) @Valid setBalanceDto: SetBalanceDto): Balance? {
        println("User from context: ${requestContext.user.name}")

        val balance = balanceService.setForUser(
            requestContext.user,
            setBalanceDto.currency,
            BigDecimal(setBalanceDto.topup_amount)
        )
        return balance
    }

    @GetMapping
    fun getBalance(): BalanceDto {
        val balance = balanceService.getForUser(requestContext.user)
        return BalanceDto(balance.BTC, balance.USD, 0)
    }
}