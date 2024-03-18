package project.DTO;

public class DTO {
	/*
	 * create table Users( 
		num NUMBER primary key, 
		pass VARCHAR2(30) not null, 
		name VARCHAR2(30) not null, 
		email VARCHAR2(30), 
		title VARCHAR2(50), 
		content VARCHAR2(1000), 
		readcount NUMBER(4) DEFAULT 0, 
		writedate date default sysdate 
	);
	 */
	private String num;
	private String id;
	private String title;
	private String content;
	private int importance;
	private String checked;
	private String date;
	private String time;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}