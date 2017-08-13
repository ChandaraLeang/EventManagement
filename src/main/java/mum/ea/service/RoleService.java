package mum.ea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.ea.domain.Role;
import mum.ea.repository.RoleRepository;

@Service
public class RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}

}
