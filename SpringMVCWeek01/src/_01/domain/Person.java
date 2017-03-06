package _01.domain;

public class Person {

	private String name;
	private String surnam;
	
	
	public Person(String name, String surnam) {
		super();
		this.name = name;
		this.surnam = surnam;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurnam() {
		return surnam;
	}
	public void setSurnam(String surnam) {
		this.surnam = surnam;
	}
	
	
	
}
