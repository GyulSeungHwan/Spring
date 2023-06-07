package com.yedam.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	
	// 포인트컷 : 조인포인트(비즈니스 로직과 관련된 메소드) 중에서 Advice(공통코드)가 적용될 메소드
	@Pointcut("within(com.yedam.app.aop.*)") // Pointcut은 두 가지를 한 번에 잡을 수가 없다
	// within - 지정된 패키지 밑에있는 모든 패키지를 가리키는 것
	public void allPointCut() {}
	
	// Weaving : 포인트컷 + Advice + 동작시점
	@Around("allPointCut()")
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable {
		// Aop가 적용되는 메서드의 이름
		String signatureStr = joinpoint.getSignature().toString();
		System.out.println("시작 : " + signatureStr);
		
		// 공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능 : " + System.currentTimeMillis());
		
		try {
			Object obj = joinpoint.proceed(); // 실제로 동작하는 시점
			return obj; // 최상위 클래스로 돌려준다, 실행시키기 전 intercept해서 붙여줄 부분 붙여주고 실행시킨 뒤에 반환해준다
		} finally {
			// 공통기능
			System.out.println("핵심 기능 후 실행 - 공통기능 : " + System.currentTimeMillis());
		}
	}
	
}
