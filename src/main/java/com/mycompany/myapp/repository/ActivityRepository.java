package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByIdNotIn(List<Long> id);
}
