package custom;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DecodeConfig {

	@Around("@within(com.liuyang.aop.Decode)")
	public Object before(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("signature      : " + jp.getSignature());
		System.out.println("kind           : " + jp.getKind());
		System.out.println("this           : " + jp.getThis());
		System.out.println("sourceLocation : " + jp.getSourceLocation());
		System.out.println("staticPart     : " + jp.getStaticPart());
		System.out.println("target         : " + jp.getTarget());
		return jp.proceed();
	}

	/**
	 * 
	 * 做解密
	 * @param o
	 * @return
	 */
	private Object doDecode(Object o) {
		return o;
	}
}
