package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("error")
    public String notFount(){
        return "error-404";
    }
}
