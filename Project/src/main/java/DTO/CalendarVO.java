package DTO;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/*
 * create table Calendar(  
 	
	Id NUMBER primary key, 
	GroupNum NUMBER,
	Title VARCHAR2(50),
	Writer VARCHAR2(50),
	Content VARCHAR2(1000), 
	Start1 DATE, 
	End1 DATE, 
	AllDay NUMBER(1),
	Color VARCHAR2(50)
);
 */

@Getter
@Setter
public class CalendarVO {

	private int id;
	private Integer groupnum;
	private String title;
	private String writer;
	private String content;
	private Timestamp start1;
	private Timestamp end1;
	private int allday;
	private String color;
}
