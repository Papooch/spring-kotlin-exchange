package cz.papooch.spring_kotlin_exchange

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApi30Config {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(Info().title("USD/BTC Exchange").version("1.0"))
            .components(
                Components().addSecuritySchemes(
                    "ApiKeyAuth",
                    SecurityScheme().name("Authorization").type(SecurityScheme.Type.APIKEY).scheme("ApiKey")
                        .`in`(SecurityScheme.In.HEADER)
                )
            )
            .addSecurityItem(SecurityRequirement().addList("ApiKeyAuth"))
    }
}