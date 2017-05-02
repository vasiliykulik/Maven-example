package ua.goit.java;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.naming.spi.ObjectFactory;
import java.util.List;

/**
 * Created by Vasiliy Kylik on 02.05.2017.
 */
@Aspect
public class LogAspect {

  @Around ("execution( * Executor.addTask(Task)) && args(task)")
  public void onExecute(ProceedingJoinPoint pjp, Task task) throws Throwable {
    /*Кастим Executor, передаем Валидатор, это вмешивание в поведение, в бизнес логику
    * А в апекты мы выносим вспомогательную логику*/
    ((Executor<Integer>)pjp.getTarget()).addTask(task,(t) -> t > 0);
    /*Поменяем логику, вызовем с Validator */
  }
}
