package pe.com.comsatel.basictodo.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
@Validated
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(
                taskService.getAllTasks(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable @Min(1) Integer id) {
        return new ResponseEntity<>(
                taskService.getTaskById(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @NotNull Task task) {
        return new ResponseEntity<>(
                taskService.createTask(task),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable @Min(1) Integer id, @RequestBody @NotNull Task task) {
        return new ResponseEntity<>(
                taskService.updateTask(id, task),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteTask(@PathVariable @Min(1) Integer id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(
                id,
                HttpStatus.OK
        );
    }
}
