package com.punith.TradeApp.Domain;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="userdetails")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="email_id")
	private String email_id;
	@Column(name="mobile_number")
	private String mobile_number;
	@Column(name="password")
	private String password;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
