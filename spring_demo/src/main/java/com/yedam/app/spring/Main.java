package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// classpath - 물리적 위치가 어디에 있든 classpath 밑에 있는 파일을 찾아가는 경로(공백이 있으면 안됨)
		
		TV tv = (TV)ctx.getBean("tv");
		tv.on();
	}

}
