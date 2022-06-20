package cz.papooch.spring_kotlin_exchange.request_context

import cz.papooch.spring_kotlin_exchange.user.User
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class RequestContext (
    var user: User = User()
)
