package klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klu.repository.UserRepo;

@Service
public class UserManager {
	
	@Autowired
	UserRepo UR;
	
	public String signup(User U)
	{
		try {
			if(UR.validateUser(U.username)>0)
					throw new Exception("Username already exists..");
			UR.save(U);
			return "New User has been added..";
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	public String login(User U)
	{
		try {
			
			if(UR.validateLogin(U.username, U.password)==1)
			{
				return "200";
			}
			else
			{
				throw new Exception("401");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
