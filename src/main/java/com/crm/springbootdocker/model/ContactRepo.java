package com.crm.springbootdocker.model;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepo extends CrudRepository<Contact, Long> {

}
