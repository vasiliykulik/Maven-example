package ua.goit.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vasiliy Kylik on 09.04.2017.
 */
public class Bootstrap implements ApplicationContextAware {
  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  private ApplicationContext applicationContext;
  private TaskProvider<Integer> taskProvider;
  /*private Executor<Integer> executor;*/

/*  public Bootstrap(TaskProvider<Integer> taskProvider) {
    this.taskProvider = taskProvider;
  }*/

  public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
    bootstrap.setApplicationContext(applicationContext);
    bootstrap.execute();
    bootstrap.execute();
  }

  public void execute() {
Executor<Integer> executor = getExecutor();
    taskProvider.getAllTasks().forEach(executor::addTask);
    executor.execute();
    System.out.println("Valid Results");
    executor.getValidResults().forEach(System.out::println);
    System.out.println("Invalid Results");
    executor.getInvalidResults().forEach(System.out::println);
  }

  private  Executor<Integer> getExecutor(){
    return (Executor<Integer>) applicationContext.getBean("serialExecutor");
  }

  public void setTaskProvider(TaskProvider<Integer> taskProvider) {
    this.taskProvider = taskProvider;
  }

/*  public void setExecutor(Executor<Integer> executor) {
    this.executor = executor;
  }*/
}