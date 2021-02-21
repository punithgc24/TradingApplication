package com.punith.TradeApp.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="userdetails")
public class User {
	
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
}
