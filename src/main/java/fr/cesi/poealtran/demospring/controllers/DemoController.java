package fr.cesi.poealtran.demospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController = @Controller + @ResponseBody
@RestController
public class DemoController {

    // @GetMapping = @RequestMapping(method="GET", name="/hello")
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }




}
