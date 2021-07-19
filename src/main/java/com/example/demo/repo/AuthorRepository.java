package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Author;


public interface AuthorRepository extends JpaRepository<Author, Integer>
{

	public List<Author> findByLastnameEquals(String qryString);

	public List<Author> findByCityEquals(String qrystring);
	 
	@Query(value = "update  Authorsset lastname =:newLastname where phonenumber=:phonenumber",nativeQuery=true)
	@Modifying
	@Transactional
	public String updateLastname(@Param("newLastname") String lastnameToUpdate, @Param("phonenumber") int phonenumber);
	

}
