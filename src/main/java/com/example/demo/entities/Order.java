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
	private String id;
	@Column
	private String address;
	@Column
	private String status;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "", orphanRemoval = true)
	private List<OrderItem> orderItems;
	@ManyToOne
	@JoinColumn(referencedColumnName = "user_id", name = "user_id")
	private Account account;
}
