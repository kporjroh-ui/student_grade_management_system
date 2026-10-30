package com.sgm.studentgrademanager.repository;

import com.sgm.studentgrademanager.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    Optional<StudentModel> searchStudentByStudentID (Long studentID);
    @Query("SELECT student FROM StudentModel student WHERE cast (student.studentID as string) LIKE CONCAT ('%', :query,'%')")
    List<StudentModel> searchStudentByStudentID(@Param("query") String query);

}
