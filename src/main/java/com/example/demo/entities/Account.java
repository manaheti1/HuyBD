package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "account",schema="huySlayer")
public class Account{
	@Id
	@Column(name="user_id")
	private String accountID;
	@Column(name="address")
	private String address;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name="email")
	private String email;
	@Column(name="gender")
	private String gender;
	@Column(name="identity_card")
	private String identityCard;
	@Column(name="phone")
	private String phone;
	@Column(name="status")
	private int status;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@ManyToOne
	@JoinColumn(referencedColumnName = "role_id",name="role_id")
	private Roles role;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account",fetch = FetchType.LAZY)
	private List<Customer> customers;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account",fetch = FetchType.LAZY)
	private List<Manager> managers;
}
