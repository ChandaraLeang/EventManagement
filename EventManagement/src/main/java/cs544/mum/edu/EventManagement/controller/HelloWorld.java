package cs544.mum.edu.EventManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/")
public class HelloWorld {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String sayHello(){
		return "Hello, SpringBoot!";
	}
}