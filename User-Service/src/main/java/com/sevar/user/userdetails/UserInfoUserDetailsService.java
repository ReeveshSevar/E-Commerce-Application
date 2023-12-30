package com.sevar.user.userdetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sevar.user.model.User;
import com.sevar.user.repository.UserRepository;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userInfo = repo.findByEmail(username);
		return userInfo.map(UserInfoUserDetails::new)
				        .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	
	}

}