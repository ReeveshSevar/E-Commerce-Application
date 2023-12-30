package com.sevar.user.service;

import java.util.List;

import com.sevar.user.model.User;

public interface UserService {
	
	User create(User user);
	
	User getUser(Integer id);

	List<User> getAll();
}
