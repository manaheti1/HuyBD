package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "cart", schema = "huySlayer")
public class Cart {
	@Id
	private String id;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "", fetch = FetchType.LAZY)
	private List<CartItem> cartItems;
	@OneToOne
	@JoinColumn(referencedColumnName = "", name = "")
	private Customer customer;
}
