package DTO;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/*
 * create table Users(  
 	
	Num NUMBER primary key, 
	Id VARCHAR2(50),
	UserName VARCHAR2(50),
	EMail VARCHAR2(100),
	Password VARCHAR2(100),
	Registration_DATE DATE,
	Is_Admin CHAR(1)
);
 */
@Getter
@Setter
public class UsersVO {

	private int num;
	private String id;
	private String username;
	private String email;
	private String password;
	private Timestamp date;
	private char is_admin;
	
}
