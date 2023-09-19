package com.anneso.exemple.services;

import org.springframework.stereotype.Component;

@Component
public class MessageService implements IMessageService{

    @Override
    public String sayHello() {
        return "Hello from the implemented source";
    }
}
