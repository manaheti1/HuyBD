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
@Table(name = "order_item",schema="huySlayer")
public class OrderItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="order_item_id")
	private String id;
	@Column 
	private int quantity;
	@Column 
	private int price;
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "order_id",referencedColumnName = "order_id")
	private Order order;
}
