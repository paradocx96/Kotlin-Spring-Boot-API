package com.iparadocx.api

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {
    @GetMapping("/")
    fun main(model: Model): String {
        model["title"] = "KOTLIN API"
        return "main"
    }
}