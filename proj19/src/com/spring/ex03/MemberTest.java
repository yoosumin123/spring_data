package com.spring.ex03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.spring.ex02.PersonService;

public class MemberTest {

	public static void main(String[] args) {
		//빈팩토리 -> getBean 해야만 호출                                                    
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml"));
		MemberService service = (MemberService) factory.getBean("memberService");
		service.listMembers();

	}

}
