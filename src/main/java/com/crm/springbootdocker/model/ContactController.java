package com.crm.springbootdocker.model;

import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
class ContactController {
    private ContactService service;

    public ContactController(ContactRepo contactRepo) {
        service.setRepo(contactRepo);
    }

    @GetMapping("/contacts")
    Collection<Contact> contacts() {
        return service.getAllContacts();
    }

    @GetMapping("/contacts/{id}")
    ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Contact res = service.getByID(id);

        if (res == null) {
        return ResponseEntity.notFound().build();           
        }
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/contacts")
    ResponseEntity<Contact> createContact(@Validated @RequestBody Contact contact) throws URISyntaxException {
        Contact res = service.saveContact(contact);
        return ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/contacts/{id}")
    ResponseEntity<Contact> deleteContact(@PathVariable Long id) {
        boolean res = service.deleteContact(id);
        if (res) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
