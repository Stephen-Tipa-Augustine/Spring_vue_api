package com.example.spring_vue_api.repository;

import com.example.spring_vue_api.models.News;

import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {
    
}
