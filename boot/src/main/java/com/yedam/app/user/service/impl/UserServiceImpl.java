package com.yedam.app.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.UserVO;
import com.yedam.app.user.mapper.UserMapper;
import com.yedam.app.user.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public UserVO getUserInfo(UserVO userVO) {
		return userMapper.selectUserInfo(userVO.getLoginId());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = userMapper.selectUserInfo(username);
		if(vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		vo.setRoleName(userMapper.selectRole(vo.getId()));
		return vo;
	}

}
