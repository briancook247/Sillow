package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/home")
public class ApplicationController 
{
    @GetMapping("/")
    public String showHomePage()
    {
        return "coverPage.html";
    }
    
}