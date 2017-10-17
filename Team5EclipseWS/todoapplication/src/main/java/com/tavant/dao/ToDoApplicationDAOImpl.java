package com.tavant.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.tavant.entity.Task;

@Repository
@Transactional
public class ToDoApplicationDAOImpl implements ToDoApplicationDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createTask(Task task) {
		System.out.println("entered");
		entityManager.persist(task);
	}

	@Override
	public List<Task> getAllTasks() {
		System.out.println("entered get");
		List<Task> taskList = entityManager.createQuery("from Task ts", Task.class).getResultList();
		if (!CollectionUtils.isEmpty(taskList)) {
			return taskList;
		}
		return new ArrayList<>();
	}
	
	@Override
	public Task updateTask(Task task) {
		System.out.println("updated");
		Task t = entityManager.merge(task);
		return t;
	}
	@Override
	public Task deleteTask(int id) {
		System.out.println("deleted");
	
        Task t = entityManager.find(Task.class, id);
        if(t != null){
        	entityManager.remove(t);
        }
         
		return t;
	}

}
