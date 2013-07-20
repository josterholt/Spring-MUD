package com.ostwebdev.fantasystrategy.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ostwebdev.fantasystrategy.repository.AreaRepository;

@NodeEntity
public class User implements UserDetails {
	@GraphId private Long id;
	
	@Indexed(indexType = IndexType.FULLTEXT, indexName = "searchByUsername2")
	private String username;
	
	private String password;

	
	public Character character;
	
	public Account account;

	private Roles[] roles;
	

	
	public User()
	{
		
	}
	
	public Roles[] getRoles()
	{
		return this.roles;
	}
	
	public enum Roles implements GrantedAuthority {
		ROLE_USER;

		public String getAuthority() {
			return name();
		}
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		this.roles = new Roles[]{ Roles.ROLE_USER };
		
		if(this.roles == null) return Collections.emptyList();
		return Arrays.<GrantedAuthority>asList(this.roles);
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
