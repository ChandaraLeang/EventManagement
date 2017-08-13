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