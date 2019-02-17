package com.utopiacloud.themyscira.themyscira

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ThemysciraApplication

fun main(args: Array<String>) {
    runApplication<ThemysciraApplication>(*args)
}
