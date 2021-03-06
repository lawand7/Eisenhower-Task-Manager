package repositiories;

import Category.Category;
import Person.Person;
import Task.Task;
import Task.TaskRepository;
import Task.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public void updateTask(Task updatedTask) {
        for (Iterator<Task> it = taskList.iterator(); it.hasNext(); ) {
            Task task = it.next();
            if (task.getUuid() == updatedTask.getUuid()) {
                it.remove();
            }
        }
        taskList.add(updatedTask);
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
    public List<Task> getTasksByStatus(Status status) {
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskList) {
            if (task.getStatus() == status) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getTaskByImportanceAndUrgency(boolean important, boolean urgent) {
        List<Task> tasks = new ArrayList<>();
        for (Task task: getOpenOrInProgressTasks()) {
            if (task.isUrgent() == urgent && task.isImportant() == important) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    private List<Task> getOpenOrInProgressTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(getTasksByStatus(Status.OPEN));
        tasks.addAll(getTasksByStatus(Status.INPROGRESS));
        return tasks;
    }


}
