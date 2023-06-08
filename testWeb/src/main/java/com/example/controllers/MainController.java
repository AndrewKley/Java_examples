package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
//    @RequestMapping("/")
//    public String home(@RequestParam(required = false) String name, @RequestParam(required = false) String color, Model page) {
//        page.addAttribute("username", name);
//        page.addAttribute("color", color);
//        return "home";
//    }

    @RequestMapping("/{color}")
    public String home(@PathVariable String color, Model page) {
        page.addAttribute("username", "Arkadiy");
        page.addAttribute("color", color);
        return "home";
    }
}
