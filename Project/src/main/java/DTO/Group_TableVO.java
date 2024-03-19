package DTO;

import lombok.Getter;
import lombok.Setter;

/*
 * create table Group_table(  
	 
	GroupNum NUMBER primary key,
	GroupName VARCHAR2(50),
	GroupColor VARCHAR2(50),
	Searchable VARCHAR2(1),
	Master VARCHAR2(50)
);
 */
@Setter
@Getter
public class Group_TableVO {

	private Integer groupnum;
	private String groupname;
	private String groupcolor;
	private String searchable;
	private String master;
}
