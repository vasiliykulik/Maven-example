package ua.goit.java;

import java.util.List;

/**
 * Created by Vasiliy Kylik on 01.05.2017.
 */
public interface TaskProvider<T> {
  List<Task<T>> getAllTasks();
}
