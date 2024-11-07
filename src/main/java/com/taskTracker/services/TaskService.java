package main.java.com.taskTracker.services;

import java.util.List;
import java.util.ArrayList;
import main.java.com.taskTracker.model.Task;
import main.java.com.taskTracker.persistence.CsvUtil;

public class TaskService {
	private List<Task> tasks = new ArrayList<>();
	
	public TaskService() {
		this.tasks = CsvUtil.readTask();
	}
	
	public void createTask(String description) {
		int id = tasks.size() > 0 ? tasks.get(tasks.size() - 1).getId() : 1;
		Task newTask = new Task(id, description, false);
		System.out.println("id: " + id);
		tasks.add(newTask);
		CsvUtil.saveTasks(tasks);
	}
	
	public List<Task> getAllTasks() {
		return tasks;
	}
	
	public void updateTask(int id, String newDescription) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				task.setDescription(newDescription);
				CsvUtil.saveTasks(tasks);
			}
		}
	}
	
	public void completeTask(int id) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				task.setStatus(true);
				CsvUtil.saveTasks(tasks);
			}
		}
	}
	
	public void deleteTask(int id) {
		tasks.removeIf(t -> t.getId() == id);
		CsvUtil.saveTasks(tasks);
	}
}
