package com.sgm.studentgrademanager.repository;

import com.sgm.studentgrademanager.model.GradesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface GradesRepository extends JpaRepository<GradesModel, Long> {

//    Optional<GradesModel> findStudentGrades (Long studentId);

}
