package com.anneso.exemple.controller;

import com.anneso.exemple.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8090/hello/say
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    @Qualifier("MessageService")
    private IMessageService service;

    @GetMapping("/say-service")
    public String sayFromService() {
        return service.sayHello();
    }

    @GetMapping("/say")
    //@RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        // Methode sayHello qui renvoie une chaîne de caractère
        return "Hello from the other side";
    }

}
