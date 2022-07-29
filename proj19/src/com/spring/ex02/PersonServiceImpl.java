package com.spring.ex02;

public class PersonServiceImpl implements PersonService{

	// 변수 선언
	private String name;
	private int age;
	
	// 생성자 만들기 - 인자 1개 (이름만)
	public PersonServiceImpl(String name) {
		super();
		this.name = name;
	}

	// 생성자 만들기 - 인자 2개 (이름, 나이)
	public PersonServiceImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	@Override
	public void sayHello() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age + "살");
		
	}
	

}
