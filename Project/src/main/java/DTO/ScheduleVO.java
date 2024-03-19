package DTO;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/*
 * create table Schedule(  
 	
	Num NUMBER primary key, 
	Id VARCHAR2(50),
	Title VARCHAR2(50),
	Content VARCHAR2(500),
	Start1 DATE,
	End1 DATE,
	Color VARCHAR2(50),
	Writer VARCHAR2(50),
	GroupNum NUMBER
);
 */

@Setter
@Getter
public class ScheduleVO {

	private Integer num;
	private String id;
	private String title;
	private String content;
	private Date start1;
	private Date end1;
	private String color;
	private String writer;
	private Integer groupnum;

}
