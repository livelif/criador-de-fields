package com.iteris.classes;

public class Table {

	String name;
	String type;
	String lenght;
	String scale;
	String notNull;

	public Table(String name, String type, String lenght, String scale, String notNull) {
		super();
		this.name = name;
		this.type = type;
		this.lenght = lenght;
		this.scale = scale;
		this.notNull = notNull;
	}
	
	
	public Table() {

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLenght() {
		return lenght;
	}
	public void setLenght(String lenght) {
		this.lenght = lenght;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getNotNull() {
		
		if (notNull.equals("TRUE")) {
			return " NOT NULL";
		}
		
		return "";
	}
	public void setNotNull(String notNull) {
		this.notNull = notNull;
	}
	
}
