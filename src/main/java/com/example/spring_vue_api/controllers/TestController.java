package com.example.spring_vue_api.controllers;

import javax.validation.Valid;

import com.example.spring_vue_api.models.Contact;
import com.example.spring_vue_api.models.News;
import com.example.spring_vue_api.payload.request.ContactRequest;
import com.example.spring_vue_api.payload.request.NewsRequest;
import com.example.spring_vue_api.repository.ContactRepository;
import com.example.spring_vue_api.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/services")
public class TestController {
	@Autowired
  	private ContactRepository contactRepository;

	@Autowired
	private NewsRepository newsRepository;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/multi")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public String multipleAccess() {
		return "Multi Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/contact-listing")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Iterable<Contact> contactListing() {
		return contactRepository.findAll();
	}

	@PostMapping("/receive-message")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public String receiveMessage(@Valid @RequestBody ContactRequest contactRequest) {
		Contact contact = new Contact(
			contactRequest.getName(),
			contactRequest.getEmail(),
			contactRequest.getMessage()
			);
			contactRepository.save(contact);
		return "Message stored successfully in the dB";
	}

	@GetMapping("/news-listing")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public Iterable<News> newsListing() {
		return newsRepository.findAll();
	}

	@PostMapping("/add-news")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addNews(@Valid @RequestBody NewsRequest newsRequest) {
		
		News news = new News(
			newsRequest.getOverview(),
			newsRequest.getDetail(),
			newsRequest.getTime(),
			newsRequest.getCategory(),
			newsRequest.getImageURL()
			);
			newsRepository.save(news);

		return "News stored successfully in the dB";
	}
}
