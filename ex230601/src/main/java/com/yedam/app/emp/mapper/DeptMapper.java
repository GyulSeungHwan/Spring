package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public DeptVO selectOne(int deptNo); // 단건 조회
	public int selectCount(DeptVO vo);
	public List<DeptVO> selectList(DeptVO vo); //전체 조회
	public int insertDept(DeptVO vo); // 등록
	public int updateDept(DeptVO vo); // 수정
	public int deleteDept(int deptNo); // 삭제
	public List<Map<String, Object>> selectManager();
	public List<Map<String, Object>> selectLocation();
}
