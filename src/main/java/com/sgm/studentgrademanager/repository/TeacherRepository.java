package com.sgm.studentgrademanager.repository;

import com.sgm.studentgrademanager.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface TeacherRepository extends JpaRepository<TeacherModel,Long> {

}
