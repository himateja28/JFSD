package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import klu.model.Employee;
import klu.model.EmployeeManager;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeManager EM;
	
	@PostMapping("/save")
	public String save(@RequestBody Employee E)
	{
		return EM.saveData(E);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Employee E)
	{
		return EM.updateData(E);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id)
	{
		return EM.deleteData(id);
	}
	
	@GetMapping("/read")
	public String read()
	{
		return EM.readData().toString();
	}
}
