package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "orders",schema="huySlayer")
public class Order {
	@Id
	@Column(name="order_id")
	private String id;
	@Column
	private String address;
	@Column
	private String status;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
	private List<OrderItem> orderItems;
	@ManyToOne
	@JoinColumn(referencedColumnName = "customer_id", name = "customer_id")
	private Customer customer;
}
