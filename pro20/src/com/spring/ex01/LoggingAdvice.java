package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("[메서드 호출 전 : LoggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		// 함수가 실행되면 얘가 반응 -> 코드 건드리지 않고도 전 후 검사 가능
		Object object = invocation.proceed();
		
		System.out.println("[메서드 호출 후 : LoggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		
		return object;
	}
	
	

}
