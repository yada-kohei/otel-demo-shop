package com.example.demo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
  private static final Logger logger = LogManager.getLogger(LogAspect.class);

  @Around("execution(* *..*.*Controller.*(..))")
  public Object startLog(ProceedingJoinPoint jp) throws Throwable {

    logger.info("メソッド開始：" + jp.getSignature());

		try {
			Object result = jp.proceed();
			// System.out.println("メソッド終了：" + jp.getSignature());
			logger.info("メソッド終了：" + jp.getSignature());

			return result;

		} catch (Exception e) {

			// System.out.println("メソッド異常終了：" + jp.getSignature());
			// e.printStackTrace();
			logger.error("メソッド異常終了：" + jp.getSignature());
			logger.error("system error", e);
			throw e;
		}
  }

	// UserDaoクラスのログ出力
	@Around("execution(* *..*.*UserMapper.*(..))")
	public Object daoLog(ProceedingJoinPoint jp) throws Throwable {

		// System.out.println("メソッド開始：" + jp.getSignature());
		logger.info("メソッド開始：" + jp.getSignature());

		try {
			Object result = jp.proceed();
			// System.out.println("メソッド終了：" + jp.getSignature());
			logger.info("メソッド終了：" + jp.getSignature());

			return result;

		} catch (Exception e) {

			// System.out.println("メソッド異常終了：" + jp.getSignature());
			// e.printStackTrace();
			logger.error("メソッド異常終了：" + jp.getSignature());
			logger.error("system error", e);
			throw e;

		}
	}
}