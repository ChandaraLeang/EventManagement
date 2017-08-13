package mum.ea.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.config.GetCurrentUser;
import mum.ea.domain.EventGroup;
import mum.ea.domain.Role;
import mum.ea.domain.User;
import mum.ea.service.EventGroupService;
import mum.ea.service.RoleService;
import mum.ea.service.UserService;
import mum.ea.service.UserServiceImpl;


@Controller
public class LoginController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private EventGroupService eventGroupService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	GetCurrentUser getCurrentUser;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			getCurrentUser.logoutUser();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/getHome", method = RequestMethod.GET)
	public String getHome(){
		
		return "fullPageMessage";
	}
	
}

/*

SELECT * FROM eadb.user;
SELECT * FROM eadb.role;
SELECT * FROM eadb.user_roles;
select * from eadb.user_groups;
SELECT * FROM eadb.event_group;
SELECT * FROM eadb.category;
SELECT * FROM eadb.event;
SELECT * FROM eadb.facility;

insert into eadb.role values(1,'ADMIN');
insert into eadb.user values(1,1,'celeto.ogrimen@gmail.com','lastname','name','$2a$10$H8J7/O.8KkjX2rVbmhaWFern6oSf5KwQFZuh.XE2yORSfrNVyCMnS');
insert into eadb.user_roles values(1,1);

insert into eadb.building values(1,'building','building','new','Other');
insert into eadb.room values(1,10,'room1','sw',1);
insert into eadb.facility values(1,'www', 1,10,'facility1',1);
insert into eadb.event values (1,'2017-01-01 11:11:11.0','name',1,'2017-01-01 11:11:11.0', 1,1,1);
insert into eadb.category values(1, 'category','category', '1');
insert into eadb.event_group values(1,'2017-01-01 11:11:11.0', 'sample group', 'sample group', '1', 1);


*/