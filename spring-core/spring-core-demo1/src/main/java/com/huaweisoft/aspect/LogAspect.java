package com.huaweisoft.aspect;

import org.aspectj.lang.JoinPoint;

public class LogAspect {

	public void before(JoinPoint jp) {
		System.out.println("----------前置通知----------");
		System.out.println(jp.getSignature().getName());
	}

	public void after(JoinPoint jp) {
		System.out.println("----------最终通知----------");
	}
}
