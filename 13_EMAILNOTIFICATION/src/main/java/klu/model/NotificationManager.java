package klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {

	@Autowired
	JavaMailSender mailSender;
	
	public String sendEmail(String toEmail,String subject ,String message)
	{
		try {
			SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setFrom("musunurihimateja@gmail.com");
			mailMessage.setTo(toEmail);
			mailMessage.setSubject(subject);
			mailMessage.setText(message);
			
			mailSender.send(mailMessage);
			
			return "Email sent successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
}
