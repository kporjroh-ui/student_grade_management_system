package com.sgm.studentgrademanager.service.impl;

import com.sgm.studentgrademanager.dto.StudentDTO;
import com.sgm.studentgrademanager.exception.StudentNotFoundException;
import com.sgm.studentgrademanager.model.StudentModel;
import com.sgm.studentgrademanager.repository.StudentRepository;
import com.sgm.studentgrademanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //GET ALL STUDENTS
    @Override
    public List<StudentDTO> getAllStudents () {
        List<StudentModel> students = studentRepository.findAll();
        return students.stream().map (this::mapToStudentDTO).collect(Collectors.toList());
    }

    //GET STUDENT DASHBOARD
    @Override
    public String viewDashboard (Model model) {
        return "";
    }

    //GET STUDENT BY ID
    @Override
    public StudentDTO getStudentByID (Long studentID){
        StudentModel student = studentRepository.findById(studentID).orElseThrow(() -> new StudentNotFoundException("Students could not be found in records."));
        return mapToStudentDTO(student);
    }

    //SEARCH STUDENT BY ID WITH THE SEARCH BAR
    @Override
    public List<StudentDTO> searchStudentByStudentID (String query) {
        List<StudentModel> students = studentRepository.searchStudentByStudentID(query);
        return students.stream().map(this::mapToStudentDTO).collect(Collectors.toList());
    }

    //DELETE STUDENT
    @Override
    public void deleteStudent (Long studentID) {
        StudentModel student = studentRepository.findById(studentID).orElseThrow(() -> new StudentNotFoundException("Student could not be deleted."));
        studentRepository.delete(student);
    }

}
