package com.api.androidapiserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AndroidApiServerApplication

fun main(args: Array<String>) {
    runApplication<AndroidApiServerApplication>(*args)
}
