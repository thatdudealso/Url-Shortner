package com.brilliant;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShortenUrlController {

	@GetMapping("/")
	public String loadIndex() {
		return "index";
	}

}
