package order.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderVO {
	private int orderId; // 구매번호
	private String product; // 구매 상품
	private String customerName; // 구매자 이름
	private Timestamp orderDate; // 주문일자
	private int price; // 상품가격
	private int totalamount; // 총 금액

		
	}


