package com.tavant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.entity.Task;
import com.tavant.service.ToDoApplicationService;


@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
	
	@Autowired
	private ToDoApplicationService toDoApplicationService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Task createTask(@RequestBody Task task) {
		toDoApplicationService.createTask(task);
		return task;
	}
	@CrossOrigin(origins="*")
	@ResponseBody
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<Task> getAllDocumentTypes() {
		List<Task> taskList = toDoApplicationService.getAllTasks();
		return taskList;
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Task updateTask(@RequestBody Task task) {
		System.out.println("*********update*******");
		Task task1 = toDoApplicationService.updateTask(task);
		return task1;
	}
	@CrossOrigin(origins="*")
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Task deleteTask(@PathVariable("id") int id) {
		System.out.println("*********delete*******");
		Task task1 = toDoApplicationService.deleteTask(id);
		return task1;
	}
}
