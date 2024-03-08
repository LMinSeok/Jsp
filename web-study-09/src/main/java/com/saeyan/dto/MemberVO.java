package com.saeyan.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
 * create table member(
	name varchar2(30),
	userid varchar2(30) PRIMARY KEy,
	pwd varchar2(20),
	email varchar2(30),
	phone char(13),
	admin number(1)
);
 */
@Data
@Setter
@Getter

public class MemberVO {
	String name;
	String userid;
	String pwd;
	String email;
	String phone;
	int admin;

}
