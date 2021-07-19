package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;

import com.example.demo.repo.AuthorRepository;

@Service
public class AuthorServices {

	@Autowired
	public AuthorRepository repo;
	
	public List<Author> getAll(){
		 return this.repo.findAll();
	 }
	
	public Author add(Author entity) {
		return this.repo.save(entity);
	}
	
	public Author update(Author entity) {
		return this.repo.save(entity);
	}
	
	public Author getById(int phonenumber)
	{
		return this.repo.findById(phonenumber)
				.orElseThrow(() -> new NoSuchElementException("Element with that phonenumber not available"));
	}
	
	
	public List<Author> getByLastname(String lastname){
		return this.repo.findByLastnameEquals(lastname);
	}

	public List<Author> getBycity(String city){
		return this.repo.findByCityEquals(city);
	}
	public Author remove(Author entity)
	{
	Optional<Author> found = this.repo.findById(entity.getPhonenumber());
		if(found.isPresent()) {
			this.repo.delete(entity);
		}else {
			throw new NoSuchElementException("phone number not found not found");
		}
		return entity;
	}	
	
	public String updateLastname(int phonenumber,String lastname) {
		return this.repo.updateLastname(lastname, phonenumber);
	}
}
