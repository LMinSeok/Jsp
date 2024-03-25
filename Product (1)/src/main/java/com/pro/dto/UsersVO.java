package com.pro.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UsersVO {
	private int num; // 
	private String id; // 아이디
	private String pass; // 비밀번호
	private String username; // 구매자 이름
	private int callnum; // 전화번호	
	private String email; // 이메일
	private Timestamp registration_date; // 
	private String is_admin; //
	private String addr; // 우편번호
	private String addr2; // 상세주소
   
}
