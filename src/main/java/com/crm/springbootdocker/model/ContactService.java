package com.crm.springbootdocker.model;

import java.util.Collection;

public class ContactService {
    private ContactRepo contactRepo;

    public void setRepo(ContactRepo repo) {
        contactRepo = repo;
    }

    public Collection<Contact> getAllContacts() {
        return (Collection<Contact>) contactRepo.findAll();
    }

    public Contact saveContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public boolean deleteContact(Long id) {

        contactRepo.deleteById(id);
        return true;
        /*
         * Contact res = contactRepo.findById(id).get();
         * if ( res == null) {
         * return false;
         * } else {
         * contactRepo.deleteById(id);
         * return true;
         * }
         */
    }

    public Contact getByID(Long id) {
        return contactRepo.findById(id).get();
    }
}
