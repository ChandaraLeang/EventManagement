package mum.ea.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.domain.EventGroup;
import mum.ea.domain.Role;
import mum.ea.domain.User;
import mum.ea.service.EventGroupService;
import mum.ea.service.RoleService;
import mum.ea.service.UserService;


@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EventGroupService eventGroupService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("RegistrationForm", user);

		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ModelAndView saveUserRegistration(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			modelAndView.addObject("RegistrationForm", user);
			modelAndView.setViewName("registration");
		} else {
			
			Set<Role> roles = new HashSet();
			Set<EventGroup> groups = new HashSet();
			Role role = new Role();
			EventGroup group = new EventGroup();
			role = roleService.findByRole("ADMIN");
			int indx = 1;
			group = eventGroupService.getGroup(indx);
			roles.add(role);
			System.out.println(role);
			groups.add(group);
			System.out.println(group);
			user.setRoles(roles);
			user.setGroups(groups);
			System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
			System.out.println(user);
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("RegistrationForm", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String getAdmin(){
		
		return "admin/administration";
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