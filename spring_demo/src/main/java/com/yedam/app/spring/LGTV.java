package com.yedam.app.spring;

import org.springframework.stereotype.Component;

@Component("tv") // 클래스 위에 있어야함, SamsungTV에도 똑같이 적혀있다면 오류가 난다 (singleton 패턴이라서)
public class LGTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링으로 LG TV 켬");
	}

}
