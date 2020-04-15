package com.davecanhaz.sca.method.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @RequestMapping(path = "/")
    private ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Hello");

        Map<String, String> model = new HashMap<>();
        model.put("hello", "world");

        return new ModelAndView("hi", model);

    }

}