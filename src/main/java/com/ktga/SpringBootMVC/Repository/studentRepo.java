package com.ktga.SpringBootMVC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ktga.SpringBootMVC.model.student;

public interface studentRepo extends JpaRepository<student, Integer> {

	List<student> findByName(String name); // query DSL(Domain Specific Language)
	
	List<student> findByNameOrderByName(String name);
	
	List<student> findByNameOrderById(String name);
	
	List<student> findByNameOrderByNameDesc(String name);

	@Query("from student where name = :name1")
	List<student> find(@Param("name1") String name2);
	
	
}
