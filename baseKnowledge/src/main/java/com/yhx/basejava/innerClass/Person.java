package com.yhx.basejava.innerClass;

public class Person {

	private static int age;
	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public Person(String n){
		this.name=n;
	}
	
	public void clothes(String color,String type){
		Cloth c=new Cloth(color,type);
		c.cloth();
	}

	class Cloth{
		private String color;
		private String type;
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		public Cloth(String c,String type){
			this.color=c;
			this.type=type;
		}
		
		public void cloth(){
			System.out.println(Person.this.name+" close a "+this.color +this.getType());
		}		
	}
	
	

	static class Tool{
		private String name;
		
		public Tool(String name){
			this.name=name;
		}
		
		public void work(){
			System.out.print("use "+this.name+" to work");
		}
	}
}
