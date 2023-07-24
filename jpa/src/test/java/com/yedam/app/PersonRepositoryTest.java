package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.domain.Person;
import com.yedam.app.domain.PersonRepository;
import com.yedam.app.domain.Phone;

@SpringBootTest
public class PersonRepositoryTest {
	
	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void 회원단건조회() {
		Person person = personRepository.findById(12L).get();
		System.out.println(person);
	}
	
//	@Test
//	@Transactional // 롤백 시키는 것
	public void 회원등록() {
		Person person = new Person();
		person.setName("홍길동");
		person.getPhones().add(new Phone("111-22222"));
		person.getPhones().add(new Phone("222-33333"));
		personRepository.save(person);
		System.out.println(person);
		Person p = personRepository.findById(1L).get(); // 첫번째 Id를 찾는다
		assertEquals(p.getPhones().size(), 2); // 리스트 크기를 비교
	}
}
