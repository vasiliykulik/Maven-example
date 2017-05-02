package ua.goit.java;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Vasiliy Kylik on 02.05.2017.
 */
public class ExecutorInterceptor implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("Interceptor. Before execution of: " + invocation.getMethod().getName());
    Object result = invocation.proceed();
    System.out.println("Interceptor. 1After execution of: " + invocation.getMethod().getName());
    return result;
  }
}
