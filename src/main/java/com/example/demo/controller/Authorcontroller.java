package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;

import com.example.demo.services.AuthorServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class Authorcontroller {
@Autowired
  public AuthorServices service;


@GetMapping(path ="/authors")
	public List<Author> getAll(){
		return this.service.getAll();
	}
@Operation(description = "This method fetches the payment  details by phone number ",
parameters = @Parameter(example = "101 or 102"))

@GetMapping(path ="/authors/{phonenumber}")
public Author getById(@PathVariable("phonenumber") int phonenumber){
	return this.service.getById(phonenumber);
}

@PostMapping(path ="/authors")
public ResponseEntity<Author> add( @RequestBody Author entity) {
	return ResponseEntity.status(HttpStatus.CREATED).body(this.service.add(entity));
}

@GetMapping(path ="/authors/lastname/{lastname}")
public List<Author> getByLname(@PathVariable("lastname") String firstname){
return this.service.getByLastname(firstname);
}

@GetMapping(path = "/authors/city/{city}")
public List<Author> getByCity(@PathVariable("city") String city ){
	
return this.service.getBycity(city);
}
@DeleteMapping(path ="/authors")
public Author remove( @RequestBody Author entity) {
	return this.service.remove(entity);
} 
@GetMapping(path = "/authors/{phonenumber}/{lastname}")
public ResponseEntity<String> updateLastname(@PathVariable("lastname") 
               String lastname,@PathVariable ("phonenumber")  int phonenumber)
 {
	 String rowupdated = this.service.updateLastname(phonenumber,lastname);
 return  ResponseEntity.ok().body(rowupdated + "Row(s) Updated ");
}
}

