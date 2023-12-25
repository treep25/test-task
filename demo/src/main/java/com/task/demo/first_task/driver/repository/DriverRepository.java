package com.task.demo.first_task.driver.repository;

import com.task.demo.first_task.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
