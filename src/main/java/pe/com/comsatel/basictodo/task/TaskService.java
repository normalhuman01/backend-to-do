package pe.com.comsatel.basictodo.task;

import java.util.List;

interface TaskService {
    List<Task> getAllTasks();

    Task getTaskById(Integer id);

    Task createTask(Task task);

    Task updateTask(Integer id, Task newTask);

    void deleteTask(Integer id);
}
