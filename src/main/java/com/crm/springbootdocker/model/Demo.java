package com.crm.springbootdocker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Demo implements CommandLineRunner {
    private final ContactService service = new ContactService();

    @Autowired
    public Demo(ContactRepo r) {
        this.service.setRepo(r);
    }

    @Override
    public void run(String... strings) throws Exception {
        service.saveContact(new Contact("Sample", "1", "sample1@gmail.com"));
        service.saveContact(new Contact("Sample", "2", "sample2@gmail.com"));
    }
}
