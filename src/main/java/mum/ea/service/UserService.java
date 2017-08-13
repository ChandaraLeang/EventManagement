package mum.ea.service;

import java.util.List;

import mum.ea.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public List<User> findAll();
	public void saveUser(User user);
}
