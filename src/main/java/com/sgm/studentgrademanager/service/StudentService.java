package com.sgm.studentgrademanager.service;

import com.sgm.studentgrademanager.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface StudentService {

//    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
//    StudentDTO updateStudent(StudentDTO studentDTO, Long studentId);
    void deleteStudent(Long studentID);
    String viewDashboard (Model model);
    StudentDTO getStudentByID (Long studentID);
    List<StudentDTO> searchStudentByStudentID (String query);
}
