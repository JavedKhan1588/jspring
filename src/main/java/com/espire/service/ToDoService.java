package com.espire.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.espire.model.ToDo;

@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<ToDo>();
	private static int todoCount = 3;
	static {
		todos.add(new ToDo(1, "javed", "Learning Servlet", new Date(), true));
		todos.add(new ToDo(2, "javed", "Learning JSP", new Date(), false));
		todos.add(new ToDo(3, "javed", "Learning Spring", new Date(), false));
	}

	public void addToDo(String name, String description, Date targetDate, boolean isDone) {
		todos.add(new ToDo(++todoCount, name, description, targetDate, isDone));
	}

	public void deleteToDo(int id) {
		Iterator<ToDo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			ToDo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}

	public List<ToDo> retrieveToDos(String user) {
		List<ToDo> filteredToDos = new ArrayList<ToDo>();
		for (ToDo todo : todos) {
			if (todo.getUser().equals(user))
				filteredToDos.add(todo);
		}
		return filteredToDos;
	}
}