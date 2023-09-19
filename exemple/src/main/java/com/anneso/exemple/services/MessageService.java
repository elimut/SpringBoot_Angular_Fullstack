package com.anneso.exemple.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("MessageService")
public class MessageService implements IMessageService{

    @Override
    public String sayHello() {
        return "Hello from the implemented source";
    }
}
