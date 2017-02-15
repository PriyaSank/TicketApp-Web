package com.ticket

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication @ComponentScan(basePackages="com.ticket") class Application {
	def static void main(String[] args) {
		SpringApplication.run(Application)
	}
}
