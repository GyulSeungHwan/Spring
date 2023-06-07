package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("aService")
public class AaaServiceImpl implements AaaService {

	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional // 내부에서 몇개의 쿼리문이 있던간에 실행시키고 문제가 없다면 commit, 문제가 있다면 전부 rollback한다
	@Override
	public void insert() { // 위아래로 있는 빨간색 화살표 - around aop가 적용되어있다는 얘기다
		aaaMapper.insert("101"); // 숫자만 있을 경우 자동으로 파싱되어서 DB에 들어간다
//		aaaMapper.insert("a101"); // DB에선 number 타입인데 숫자가 아니라서 테스트 할때 오류가 뜬다(VARCHAR타입이었다면 문제가 없었을 것이다)
		aaaMapper.insert("901");
	}

}
