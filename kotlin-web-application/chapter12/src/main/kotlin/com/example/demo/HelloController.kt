package com.example.demo

import org.springframework.web.bind.annotation.*


@RestController
class HelloController(private val greeter: Greeter) {
    @GetMapping("hello")
    fun hello(@RequestParam("name") name: String): String = greeter.hello(name)
}