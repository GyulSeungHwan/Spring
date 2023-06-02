package com.yedam.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DeptMapperClient {
	
	@Autowired
	DeptMapper deptMapper;
	
//	@Test
	@Ignore
	public void getDeptInfo() {
		DeptVO findDept = deptMapper.selectOne(60);
		assertEquals(findDept.getDepartmentName(), "IT");
	}
	
//	@Test
	@Ignore
	public void 전체조회() {
		DeptVO param = new DeptVO();
		param.setDepartmentId("60");
		List<DeptVO> list = deptMapper.selectList(param);
		int cnt = deptMapper.selectCount(param);
		for(DeptVO dept : list) {
			System.out.println(dept);
		}
	}
	
//	@Test
	@Ignore
	public void 등록() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentName("unemployed");
		vo.setManagerId(null);
		vo.setLocationId(null);
		deptMapper.insertDept(vo);
		System.out.println(vo.getDepartmentId());
	}
}
