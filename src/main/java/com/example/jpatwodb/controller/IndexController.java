package com.example.jpatwodb.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public void error(HttpServletResponse response) throws IOException {
        System.out.println("In the error page~~~~~");
        response.sendRedirect("/login");   //provide your error page url or home url
    }

//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }
}