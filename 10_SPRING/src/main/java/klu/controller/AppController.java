package klu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@RequestMapping("/")
	public ModelAndView index()
	{
		ModelAndView mvc = new ModelAndView();
		mvc.setViewName("employee");
		return mvc;
	}
}
