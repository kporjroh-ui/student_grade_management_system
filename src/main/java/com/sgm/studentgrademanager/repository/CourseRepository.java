package com.sgm.studentgrademanager.repository;

import com.sgm.studentgrademanager.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseModel, Long> {

}
