package mum.ea.service;

import mum.ea.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
