package com.swd.springbootwebjsp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String SayHello(Model model) {
        model.addAttribute("hello", "你好");
        return "success";
    }
}

