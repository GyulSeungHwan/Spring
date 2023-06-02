package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectOne(int empNo); // 단건 조회
	public int selectCount(EmpVO vo);
	public List<EmpVO> selectList(EmpVO vo); // 전체 조회
	public int insertEmp(EmpVO vo); // 등록 (int 대신 void도 됨)
	public int updateEmp(EmpVO vo); // 수정
	public int deleteEmp(int empNo); // 삭제
	public List<Map<String, Object>> selectJobs();
	public List<Map<String, Object>> selectDept();
	// 목록 구하는 쿼리랑 건수 구하는 쿼리랑 받는 값이 같아야 한다
}
