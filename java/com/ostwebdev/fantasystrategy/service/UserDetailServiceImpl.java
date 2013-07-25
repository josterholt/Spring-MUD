package com.ostwebdev.fantasystrategy.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ostwebdev.fantasystrategy.domain.User;
import com.ostwebdev.fantasystrategy.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService, InitializingBean {
	
	@Autowired private UserRepository userRepo;

	public UserDetails loadUserByUsername(String username)
	{
		try {
			User user = userRepo.findByUsername(username);
			if(user == null) {
				return new User();
			}
			return user;
		} catch(Exception e) {
			System.out.println(e.toString());
			return new User();
		}

	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
