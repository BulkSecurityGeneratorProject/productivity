package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Activity;
import com.mycompany.myapp.domain.ActivityExecution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActivityExecutionRepository extends JpaRepository<ActivityExecution, Long> {
    List<ActivityExecution> findByExecutionDate(LocalDate localDate);
    List<ActivityExecution> findByExecutionDateBetween(LocalDate start, LocalDate end);
}
