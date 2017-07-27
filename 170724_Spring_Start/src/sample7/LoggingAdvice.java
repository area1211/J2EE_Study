package sample7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice {
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
		String methodName=pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD: "+methodName+" is calling");
		Object rtnObj = pjp.proceed();
		sw.stop();
		System.out.println("[LOG] METHOD: "+methodName+" was called");
		
		System.out.println("[LOG] ó���ð�: "+sw.getTotalTimeMillis()/1000+"��");
		return rtnObj;
	}
}