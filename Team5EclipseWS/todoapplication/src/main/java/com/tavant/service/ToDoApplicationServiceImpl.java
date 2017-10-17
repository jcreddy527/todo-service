package com.tavant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.dao.ToDoApplicationDAO;
import com.tavant.entity.Task;

@Service
public class ToDoApplicationServiceImpl implements ToDoApplicationService {
	
	@Autowired
	private ToDoApplicationDAO toDoApplicationDAO;
	
	@Override
	public void createTask(Task task) {
		toDoApplicationDAO.createTask(task);
		
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks =  toDoApplicationDAO.getAllTasks();
		return tasks;
	}

	@Override
	public Task updateTask(Task task) {
		Task task1 =  toDoApplicationDAO.updateTask(task);
		return task1;
	}

	@Override
	public Task deleteTask(int id) {
		Task task1 =  toDoApplicationDAO.deleteTask(id);
		return task1;
	}
	
}
