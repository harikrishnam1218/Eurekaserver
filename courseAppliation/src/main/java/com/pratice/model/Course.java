package com.pratice.model;

public class Course {
	private Long id;
	
	private String name;
	
	private String desc;
	
	private Integer months;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Course(Long id, String name, String desc, Integer months) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.months = months;
	}

	public Course() {
		super();
	}
	
	

}
