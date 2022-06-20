package cz.papooch.spring_kotlin_exchange.request_context

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class RequestContextInterceptorConfig(
    val requestContextInterceptor: RequestContextInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(requestContextInterceptor).excludePathPatterns(
            // exclude swagger-ui urls
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**"
        )
    }
}