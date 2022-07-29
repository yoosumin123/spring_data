package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest2 {

	public static void main(String[] args) {
		                      // 빈 팩토리 만들기    // xml 파일 불러와
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		// 유언뿐이다 -> Impl이 갖고있다. (의존)
		PersonService person1 = (PersonService) factory.getBean("personService1");
		person1.sayHello();
		System.out.println();
		
		PersonService person2 = (PersonService) factory.getBean("personService2");
		person2.sayHello();

	}

}
