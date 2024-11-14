package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.model.JwtService;

@RestController
@RequestMapping("/jwt")
public class JwtController {

	@Autowired
	JwtService JM;
	
	@GetMapping("/generatetoken/{uname}")
	public String generateToken(@PathVariable("uname") String username)
	{
		return JM.generateToken(username);
	}
	
	@GetMapping("/validatetoken/{jwttoken}")
	public String validateToken(@PathVariable("jwttoken") String token)
	{
		return JM.validateToken(token);
	}
}
