package com.example.thymeleafcrudeapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showMorePage(){
        return "index";
    }
}
