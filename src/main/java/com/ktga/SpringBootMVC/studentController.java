package com.ktga.SpringBootMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktga.SpringBootMVC.Repository.studentRepo;
import com.ktga.SpringBootMVC.model.student;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // - it takes @ResponseBody so no need of it
public class studentController {
	
	@Autowired
	studentRepo sr;
	
	@GetMapping(path="Students",produces = "application/xml")
	// @ResponseBody - use to specify that return type was not change by anything 
	public List<student> getStudents(){
		return sr.findAll();
	}
	
	@GetMapping("Student/{id}")
	// @ResponseBody
	public student getStudent(@PathVariable("id") int id){
		// return sr.getOne(id);
		return sr.findById(id).orElse(new student(0,""));
	}
											// or consumes = "application/json"
	@PostMapping(path="Student", consumes = {MediaType.APPLICATION_JSON_VALUE})      // @RequestBody used to convert the json/xml to java object
	// @ResponseBody
	public student setStudent(@RequestBody student s){
		// return sr.getOne(id);
		return sr.save(s);
	}
									
	@PutMapping("Student")
	public student updateStudent(student s) {
		return sr.save(s);
	}
	
	@DeleteMapping("Student/{id}")    
	public void deleteStudent(@PathVariable("id") int id) {
		sr.deleteById(id);
		System.out.println(id);
	}
}
