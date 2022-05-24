package repositiories;

import Category.Category;
import Person.Person;
import Task.Task;
import Task.TaskRepository;
import Task.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepositoryImplementation implements TaskRepository {
    private final List<Task> taskList;

    public TaskRepositoryImplementation() {
        this.taskList = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }



    @Override
    public void removeTask(Task task) {
        taskList.remove(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public List<Task> getTasksByResponsiblePerson(Person responsiblePerson) {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (task.getResponsiblePerson() == responsiblePerson) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getTasksByCategory(Category category) {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (task.getCategory() == category) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getOpenTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (task.getStatus() == Status.OPEN) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getInProgressTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (task.getStatus() == Status.INPROGRESS) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getImportantTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (task.isImportant()) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getUrgentTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (task.isUrgent()) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getUnimportantTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (!task.isImportant()) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getNotUrgentTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (!task.isUrgent()) {
                tasks.add(task);
            }
        }
        return tasks;
    }


}