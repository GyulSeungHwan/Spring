package com.yedam.app.user.service;

import com.yedam.app.security.UserVO;

public interface UserService {

	// 단건조회
	public UserVO getUserInfo(UserVO userVO);

}
