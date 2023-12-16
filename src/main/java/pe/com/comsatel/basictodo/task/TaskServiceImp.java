package pe.com.comsatel.basictodo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskRepository.findAll());

    }

    @Override
    public Task getTaskById(Integer id) {
        assert id > 0;
        return taskRepository.findById(this.getIndex(id)).orElseThrow(RuntimeException::new);
    }

    @Override
    public Task createTask(Task task) {
        assert task != null;
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Integer id, Task newTask) {
        assert id > 0 && newTask != null;
        Task task = this.getTaskById(id);
        task.setDescription(newTask.getDescription());
        task.setState(newTask.getState());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        assert id > 0;
        taskRepository.deleteById(this.getIndex(id));
    }

    private int getIndex(Integer id) {
        return id;
    }
}
