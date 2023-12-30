package com.sevar.user.userdetails;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sevar.user.model.User;

//   Here We Are Converting UserInfo To UserDetails

public class UserInfoUserDetails implements UserDetails 
{
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String pwd;
	
	private List<GrantedAuthority> authorities;

	public UserInfoUserDetails(User info)
	{
		username=info.getEmail();
		
		pwd=info.getPassword();
		
		authorities=Arrays.stream(info.getRole().split(","))
						  .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
