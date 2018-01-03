package com.libertymutual.goforcode.wimp.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	@RequestMapping("/")
	public ModelAndView homeView() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
