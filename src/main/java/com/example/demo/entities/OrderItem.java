package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "order_item",schema="huySlayer")
public class OrderItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Column 
	private int quantity;
	@Column 
	private int price;
	@OneToMany
	@JoinColumn(name = "",referencedColumnName = "")
	private Product product;
	@OneToMany
	@JoinColumn(name = "",referencedColumnName = "")
	private Order order;
}
