package mum.ea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.User;


@Controller
public class LoginController {

	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		//User user = new User();
		//modelAndView.addObject("user", user);
		
		//not yet included
		modelAndView.setViewName("/login");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String getAdmin(){
		
		return "admin/administration";
	}
}

/*
SELECT * FROM eadb.user;
SELECT * FROM eadb.role;
SELECT * FROM eadb.user_roles;

insert into eadb.role values(1,'ADMIN');
insert into eadb.user values(1,1,'uremail@gmail.com','lastname','name','$2a$10$H8J7/O.8KkjX2rVbmhaWFern6oSf5KwQFZuh.XE2yORSfrNVyCMnS');
insert into eadb.user_roles values(1,1);

use eadb;
select u.email, r.role from user u inner join user_roles ur 
	on(u.user_id=ur.user_user_id) inner join role r 
    on(ur.roles_role_id=r.role_id) where u.email='uremail@gmail.com';
    select u.email, r.role from user u inner join user_roles ur on(u.user_id=ur.user_user_id) inner join role r 
    on(ur.roles_role_id=r.role_id) where u.email='uremail@gmail.com';
*/