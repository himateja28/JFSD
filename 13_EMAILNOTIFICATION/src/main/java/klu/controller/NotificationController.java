package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.model.Email;
import klu.model.NotificationManager;

@RestController
@RequestMapping("/email")
public class NotificationController {
	
	@Autowired
	NotificationManager NM;
	
	@PostMapping("/send")
	public String send(@RequestBody Email em)
	{
		return NM.sendEmail(em.getToemail(), em.getSubject(), em.getMessage());
	}
}
