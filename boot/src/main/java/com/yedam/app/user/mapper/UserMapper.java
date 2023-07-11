package com.yedam.app.user.mapper;

import java.util.List;

import com.yedam.app.security.UserVO;

public interface UserMapper {
	
	// 단건조회
	public UserVO selectUserInfo(String id);
	// 권한조회
	public List<String> selectRole(String id);
	
}
