package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper; // 인터페이스를 상속받은 구현클래스를 주입받음
	
//	@Test
	@Ignore
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		assertEquals(findEmp.getFirstName(), "Steven");
		// assertEquals - 두 개의 값이 같은지 틀린지 비교하는 것
	}
	
//	@Test
//	public void 건수() {
//		int cnt = empMapper.selectCount(null);
//	}
	
//	@Test
	@Ignore
	public void 전체조회() {
		EmpVO param = new EmpVO();
		param.setDepartmentId("50, 90");
//		param.setFirstName("e");
		param.setOrderColumn("department_id, first_name");
		// xml의 $는 ''(따옴표)가 없이 들어가기 때문에 "" 안에서 써준 것이다
		List<EmpVO> list = empMapper.selectList(param);
		int cnt = empMapper.selectCount(param);
		for(EmpVO emp : list) {
			System.out.println(emp);			
		}
//		assertEquals(list.get(0).getEmployeeId(), "100");
	}
	
//	@Test
	@Ignore
	public void 등록() {
		EmpVO vo = new EmpVO();
		vo.setLastName("kim");
		vo.setEmail("a@a.a");
		vo.setHireDate("23/12/01");
		vo.setJobId("IT_PROG");
		empMapper.insertEmp(vo);
		// 등록 후에 id를 사용할 경우 selectkey 이용
		System.out.println(vo.getEmployeeId());
//		EmpVO vo = new EmpVO();
//		vo.setEmployeeId("503");
//		vo.setLastName("killdong");
//		vo.setEmail("qweasd3@naver.com");
//		vo.setHireDate("2023-06-02");
//		vo.setJobId("IT_PROG");
//		
//		empMapper.insertList(vo);
//		EmpVO findEmp = empMapper.selectOne(Integer.parseInt(vo.getEmployeeId()));
//		assertEquals(findEmp.getLastName(), "killdong");
	}
	
//	@Test
	@Ignore
	public void selectJobs() {
		List<Map<String, Object>> list = empMapper.selectJobs();
		assertNotNull(list);
	}
	
	@Test
	public void selectDept() {
		List<Map<String, Object>> list = empMapper.selectDept();
		assertNotNull(list);
	}
}
