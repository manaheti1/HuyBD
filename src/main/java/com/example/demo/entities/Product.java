package com.example.demo.entities;

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
@Table(name = "product", schema = "huySlayer")
public class Product {
	@Id
	@Column(name="product_id")
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private int price;
	@Column(name = "status")
	private int status;
	@Column(name = "description")
	private String description;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private List<OrderItem> orderItems;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private List<CartItem> cartItems;
	@ManyToOne
	@JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id")
	private Promotion promotion;
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
}
