package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.model.StudentManager;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentManager SM ;
	
	@GetMapping("/getstudents/{cpage}/{psize}")
	public String getStudents(@PathVariable("cpage")Long cPage, @PathVariable("psize") Long pSize)
	{
		return SM.getData(cPage-1, pSize);
	}
	
	@GetMapping("/getpaging/{psize}")
	public String getPaging(@PathVariable("psize") Long pSize)
	{
		return SM.getPaging(pSize).toString();
	}
}
