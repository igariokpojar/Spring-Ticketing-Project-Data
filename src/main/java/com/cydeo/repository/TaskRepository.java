package com.cydeo.repository;

import com.cydeo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("select count (t) from Task t where t.project.projectCode = ?1 and t.taskStatus<>'COMPLETED'")
    int totalNonCompletedTask(String projectCode);

    @Query(value = "SELECT COUNT(*) " +
            "FROM tasks t JOIN projects p on t.project_id=p.id " +
            "WHERE p.project_code=?1 AND t.task_status='COMPLETE'",nativeQuery = true)
    int  totalCompletedTask(String projectCode);


}