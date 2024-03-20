package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order1 {
	private String order_date;
	private int custcode;
	private String order_desc;
	private int sabun;
	private String order_status;

	private String custname;
	private String sawon_name;
}