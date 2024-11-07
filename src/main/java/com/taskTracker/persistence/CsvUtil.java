package main.java.com.taskTracker.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.taskTracker.model.Task;

public class CsvUtil {
	private static final String FILE_PATH = "tasks.csv";
	
	public static List<Task> readTask() {
		List<Task> tasks = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH)) ) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				int id = Integer.parseInt(fields[0]);
				String description = fields[1];
				boolean status = fields[2].equals("1");
				tasks.add(new Task(id, description, status));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	public static void saveTasks(List<Task> tasks) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (Task task : tasks) {
				bw.write(task.formatToCsv());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
