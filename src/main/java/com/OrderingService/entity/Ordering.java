package com.OrderingService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordering")
public class Ordering {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private int orderId;
	
	@Column(name = "customerid")
	private String customerId;
	
	@Column(name = "menuid")
	private String menuId;
	
	@Column(name = "deliverymanid")
	private String deliveryManId;
	
	@Column(name = "paymenttype")
	private String paymentType;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "status")
	private String status;

	public Ordering() {
		super();
	}

	public Ordering(int orderId, String customerId, String menuId, String deliveryManId, String paymentType,
			float price, String status) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.menuId = menuId;
		this.deliveryManId = deliveryManId;
		this.paymentType = paymentType;
		this.price = price;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getDeliveryManId() {
		return deliveryManId;
	}

	public void setDeliveryManId(String deliveryManId) {
		this.deliveryManId = deliveryManId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
