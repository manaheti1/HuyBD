package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cart_item", schema = "huySlayer")
public class CartItem {
	@Id
	private String id;
	@Column(name = "")
	private int quantity;
	@Column(name = "")
	private int price;
	@ManyToOne
	@JoinColumn(referencedColumnName = "", name = "")
	private Product product;
	@ManyToOne
	@JoinColumn(referencedColumnName = "", name = "")
	private Cart cart;
}
