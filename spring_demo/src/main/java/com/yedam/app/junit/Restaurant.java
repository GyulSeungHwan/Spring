package com.yedam.app.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	@Autowired // 자동으로 주입한다는 것
	Chef chef;
	
	public void open() {
		chef.cooking();
	}
}
