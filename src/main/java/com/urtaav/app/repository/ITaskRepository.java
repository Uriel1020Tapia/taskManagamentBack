package com.urtaav.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.urtaav.app.dto.CountType;
import com.urtaav.app.model.Task;

public interface ITaskRepository extends JpaRepository<Task, Long>{

	@Query(value="Select * from task order by due_date desc", nativeQuery = true)
	public List<Task> getAllTaskDueDateDesc();
	
//	@Query(value="Select new com.urtaav.app.dto.CountType(COUNT(*)/(Select COUNT(*) from Task) *100,type) from Task GROUP BY type")
	@Query(value="Select new com.urtaav.app.dto.CountType(COUNT(*)* 100 / (SELECT COUNT(*) FROM Task),type) from Task GROUP BY type")
	public List<CountType> getPercentageGroupByType();
}
