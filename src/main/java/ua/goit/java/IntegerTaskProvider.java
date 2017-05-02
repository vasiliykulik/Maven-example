package ua.goit.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasiliy Kylik on 01.05.2017.
 */
public class IntegerTaskProvider implements TaskProvider<Integer> {

  private List<Task<Integer>> tasks = new ArrayList<>();

  public void init(){
    tasks.add(new AddTask(1,2));
    tasks.add(new AddTask(1, -2));
    tasks.add(new AddTask(1, 2));
    tasks.add(new AddTask(1, -2));
    tasks.add(new AddTask(Integer.MAX_VALUE, 1));

  }
  @Override
  public List<Task<Integer>> getAllTasks() {
    return tasks;
  }
}
