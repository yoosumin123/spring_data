package com.spring.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {

	public static void main(String[] args) {
		// 호출과 동시에 다 생성 됨 
		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		System.out.println("SecondBean 얻기");
		// lazy 걸린 애 진짜 호출
		context.getBean("secondBean");
		

	}

}
