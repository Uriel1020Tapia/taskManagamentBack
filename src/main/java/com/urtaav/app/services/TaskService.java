package com.urtaav.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.urtaav.app.dto.CountType;
import com.urtaav.app.model.Task;
import com.urtaav.app.repository.ITaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

	private ITaskRepository taskRepository;

	@Transactional(readOnly = true)
	public List<Task> getTasks() {
		return taskRepository.getAllTaskDueDateDesc();
	}

	@Transactional
	public Task save(Task task) {
		return taskRepository.saveAndFlush(task);
	}

	@Transactional(readOnly = true)
	public boolean existById(Long id) {
		return taskRepository.existsById(id);
	}

	@Transactional(readOnly = true)
	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}
	

	public void delete(Long id) {
		taskRepository.deleteById(id);
	}
	
	public List<CountType> getPercentageGroupByType() {
		return taskRepository.getPercentageGroupByType();
	}
}
