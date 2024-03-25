package com.pro.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	private String orderId; // 구매자 아이디
	private String customerName; // 구매자 이름
	private String product; // 구매 상품
	private Timestamp orderDate; // 주문일자
	private int price; // 상품가격
}
