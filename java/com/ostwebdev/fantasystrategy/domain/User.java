package com.ostwebdev.fantasystrategy.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@NodeEntity
@TypeAlias("User")
public class User implements UserDetails {
	@GraphId private Long id;
	
	@Indexed(indexType = IndexType.FULLTEXT, indexName = "searchByUsername")
	private String username;
	
	private String password;

	/*	
	@RelatedTo(type="OWNED_BY", direction = Direction.INCOMING)
	public Account account = null;

	@RelatedTo(type="OWNS")
	Set<Character> characters;


	@RelatedTo(type="ACTIVELY_USING", direction = Direction.OUTGOING)
	private Character activeCharacter = null;
	*/
	private Roles[] roles;
		
	public User()
	{
		
	}
	/*
	public List<Character> getCharacters()
	{
		return this.characters;
	}
	
	public Boolean addCharacter(Character character) {
		if(!this.characters.contains(character)) {
			this.characters.add(character);
			return true;
		}
		return false;
	}
	
	public Boolean removeCharacter(Character character) {
		if(this.characters.remove(character)) {
			return true;
		}
		return false;
	}
	public Character getActiveCharacter() {
		return this.activeCharacter;
	}
	
	public void setActiveCharacter(Character character) {
		this.activeCharacter = character;
	}
	*/
	
	/**
	 * Authorization methods
	 * @todo should probably move these to separate class
	 */
	/*
	public Roles[] getRoles()
	{
		return this.roles;
	}
	*/
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
