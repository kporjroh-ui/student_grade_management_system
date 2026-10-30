package com.sgm.studentgrademanager.repository;

import com.sgm.studentgrademanager.model.EnrollmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<EnrollmentModel,Long> {
    List<EnrollmentModel> findByStudent_StudentIDAndStatusNot(Long studentId, String status);
    List<EnrollmentModel> findByCourse_CourseID(Long courseId);
    boolean existsByStudent_StudentIDAndCourse_CourseIDAndSemesterName(Long studentID, Long courseID, String semesterName);
}
