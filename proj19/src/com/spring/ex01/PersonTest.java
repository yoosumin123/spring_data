package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
                         // Spring 컨테이너    // xml 파일 불러오기
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
       //유언뿐 -> Impl (의존)      // 강제형변환             
		PersonService person = (PersonService) factory.getBean("personService");
		//PersonService person = new PersonServiceImpl();
		person.sayHello();

	}

}