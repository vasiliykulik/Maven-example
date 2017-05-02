package ua.goit.java;

import org.aspectj.lang.ProceedingJoinPoint;

import javax.naming.spi.ObjectFactory;

/**
 * Created by Vasiliy Kylik on 02.05.2017.
 */
public class LogAspect {
  public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("LogAspect. Before execution of: " + pjp.getSignature().getName());
    Object result =  pjp.proceed();
    System.out.println("LogAspect. After execution of: " + pjp.getSignature().getName());
    return result;
  }
}
