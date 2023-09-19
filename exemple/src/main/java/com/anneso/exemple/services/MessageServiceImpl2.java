package com.anneso.exemple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
// @Primary
public class MessageServiceImpl2 implements IMessageService {

        @Override
        public  String sayHello() {
            return "Hello rom the second";
        }

}
