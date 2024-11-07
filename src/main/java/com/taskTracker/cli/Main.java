package main.java.com.taskTracker.cli;

import java.util.Scanner;

import main.java.com.taskTracker.model.Task;
import main.java.com.taskTracker.services.TaskService;

public class Main {

	public static void main(String[] args) {
		TaskService taskService = new TaskService();
		Scanner scanner = new Scanner(System.in);
		int option;
		
		do {
			System.out.println("Selecciona una opción:");
            System.out.println("1. Crear Tarea");
            System.out.println("2. Listar Tareas");
            System.out.println("3. Actualizar Tarea");
            System.out.println("4. Eliminar Tarea");
            System.out.println("5. Marcar como completada");
            System.out.println("6. Salir");
            
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (option) {
            	case 1:
            		System.out.println("Introduce la descripción de la tarea:");
            		String descripcion = scanner.nextLine();
            		taskService.createTask(descripcion);
            		System.out.println("Tarea creada.");
            		break;
            		
            	case 2:
            		System.out.println("Listado de tareas:");
            		for (Task task : taskService.getAllTasks()) {
            			System.out.println(task.getId() + ": " + task.getDescription() + " - " + (task.getStatus() ? "Completada" : "Pendiente"));
            		}
            		break;
            		
            	case 3:
            		System.out.println("Introduce el ID de la tarea a actualizar:");
            		int idToUpdate = scanner.nextInt();
            		scanner.nextLine();
            		System.out.println("Introduce la nueva descripción:");
            		String newDescription = scanner.nextLine();
            		taskService.updateTask(idToUpdate, newDescription);
            		System.out.println("Tarea actualizada.");
            		break;
            	
            	case 4:
            		System.out.println("Introduce el ID de la tarea a eliminar:");
                    int idToDelete = scanner.nextInt();
                    taskService.deleteTask(idToDelete);
                    System.out.println("Tarea eliminada.");
                    break;
            		
            	case 5:
            		System.out.println("Introduce el ID de la tarea a marcar como completada: ");
            		int idToComplete = scanner.nextInt();
            		taskService.completeTask(idToComplete);
            		System.out.println("Tarea terminada.");
            		break;
            		
            	case 6:
            		System.out.println("Saliendo del programa.");
                    break;
            }
		} while (option != 6);
		
		scanner.close();
	}

}
