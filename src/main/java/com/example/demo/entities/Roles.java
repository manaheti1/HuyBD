package com.example.demo.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "roles", schema = "huySlayer")
public class Roles {
	@Id
	@Column(name="role_id")
	private int roleID;
	@Column
	private String roleName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private List<Account> accounts;
	public Roles(String roleName) {
	    super();
	    this.roleName = roleName;
	  }
	public Roles(int roleID, String roleName) {
	    super();
	    this.roleID = roleID;
	    this.roleName = roleName;
	  }
	@Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Roles other = (Roles) obj;
	    return Objects.equals(accounts, other.accounts) && roleID == other.roleID
	        && Objects.equals(roleName, other.roleName);
	  }
}
