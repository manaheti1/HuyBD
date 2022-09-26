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
	@Column(name="cart_item_id")
	private String id;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "price")
	private int price;
	@ManyToOne
	@JoinColumn(referencedColumnName = "product_id", name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(referencedColumnName = "cart_id", name = "cart_id")
	private Cart cart;
}
