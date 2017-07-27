package simple6;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		
		// 스프링에서 어드바이스용
		String methodName=arg0.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start();
		
		System.out.println("[LOG] METHOD: "+methodName+" is calling");
		Object rtnObj = arg0.proceed();
		sw.stop();
		System.out.println("[LOG] METHOD: "+methodName+" was called");
		
		System.out.println("[LOG] 처리시간: "+sw.getTotalTimeMillis()/1000+"초");
		
		return rtnObj;
	}

}
