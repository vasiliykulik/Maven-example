package ua.goit.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vasiliy Kylik on 09.04.2017.
 */
public class Bootstrap {

  private TaskProvider<Integer> taskProvider;
  private ExecutorFactory executorFactory;

  public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "aop-context.xml");
    Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
    bootstrap.execute();
    bootstrap.execute();
  }

  public void execute() {
    Executor<Integer> executor = executorFactory.getIntegerExecutor();
    taskProvider.getAllTasks().forEach(executor::addTask);
    executor.execute();
    System.out.println("Valid Results");
    executor.getValidResults().forEach(System.out::println);
    System.out.println("Invalid Results");
    executor.getInvalidResults().forEach(System.out::println);
  }

  public void setTaskProvider(TaskProvider<Integer> taskProvider) {
    this.taskProvider = taskProvider;
  }

  public void setExecutorFactory(ExecutorFactory executorFactory) {
    this.executorFactory = executorFactory;
  }
}