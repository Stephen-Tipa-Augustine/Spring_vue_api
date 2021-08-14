package com.example.spring_vue_api.repository;
import com.example.spring_vue_api.models.Contact;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    
}
