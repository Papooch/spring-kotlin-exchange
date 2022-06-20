package cz.papooch.spring_kotlin_exchange.request_context

import cz.papooch.spring_kotlin_exchange.annotations.IsPublic
import cz.papooch.spring_kotlin_exchange.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class RequestContextInterceptor(
    val userService: UserService,
    val requestContext: RequestContext
): HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        if (handler !is HandlerMethod) return true

        val isPublic = handler.getMethodAnnotation(IsPublic::class.java)
        if (isPublic !== null) {
            println("Route is public")
            return true
        }

        println("Route is not public")
        val token = request.getHeader("authorization")
            ?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization header required")
        val userByToken = userService.getUserByToken(token)
            ?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token")
        requestContext.user = userByToken
        println("User from header: ${userByToken.name}")
        return true
    }
}