package cz.papooch.spring_kotlin_exchange

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.logging.Logger


@SpringBootApplication
class SpringKotlinExchangeApplication : ApplicationRunner {
		override fun run(args: ApplicationArguments?) {
		val className = this::class.simpleName?.substringBefore('$') ?: ""
		val logger = Logger.getLogger(className)
		logger.info("Class Name: $className")
		logger.info("I AM STARTING again")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringKotlinExchangeApplication>(*args)
}
