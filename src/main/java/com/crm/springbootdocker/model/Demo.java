package com.crm.springbootdocker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Demo implements CommandLineRunner {
    private final ContactRepo repo;

    @Autowired
    public Demo(ContactRepo r) {
        this.repo = r;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repo.save(new Contact("A", "A1", "A@gmail.com"));
    }
}
