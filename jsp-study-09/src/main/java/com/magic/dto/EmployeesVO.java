package com.magic.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*	id varchar2(10) Not NULL,
	pass varchar2(10) Not NULL,
	name VARCHAR2(24),
	lev char(1) DEFAULT 'A',  -- A:운영자, B:일반회원
	enter DATE DEFAULT SYSDATE, -- 등록일
	gender CHAR(1) DEFAULT '1', --1:남자, 2:여자
	phone varchar2(30),
	PRIMARY KEY(id)
	);
 */
@Setter
@Getter
@ToString
public class EmployeesVO {
	String id;
	String pass;
	String name;
	String lev;
	Date enter;
	String gender;
	String phone;
}
