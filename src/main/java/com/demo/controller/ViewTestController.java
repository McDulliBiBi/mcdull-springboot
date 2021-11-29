package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/index")
    public String index(Model model) {
        int u = 10/0;
        model.addAttribute("msg", "hello mcdull");
        model.addAttribute("link", "http://www.baidu.com");

        return "index-mcdull";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "redirect:/index";
    }
}
