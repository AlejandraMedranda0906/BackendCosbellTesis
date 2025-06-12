package com.cosbell.spa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendCosbellApplication

fun main(args: Array<String>) {
	runApplication<BackendCosbellApplication>(*args)
}