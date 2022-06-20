package cz.papooch.spring_kotlin_exchange.annotations

import io.swagger.v3.oas.annotations.security.SecurityRequirements

/**
 * Mark handler method as public
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@SecurityRequirements(/* disable openapi security */)
annotation class IsPublic
