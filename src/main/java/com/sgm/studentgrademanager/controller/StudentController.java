package com.sgm.studentgrademanager.controller;

import com.sgm.studentgrademanager.dto.StudentDTO;
import com.sgm.studentgrademanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService) {

        this.studentService = studentService;
    }

    // GET ALL STUDENTS (LIST)
    @GetMapping("/students")
    public String studentsList (Model model) {
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    // GET STUDENT DASHBOARD
    @GetMapping("/student_dashboard")
    public String viewDashboard (Model model) {
        String studentDashboard = studentService.viewDashboard(model);
        model.addAttribute("studentDashboard", studentDashboard);
        return "student_dashboard";
    }

    // GET STUDENT BY ID
    @GetMapping("/students/{studentID}")
    public String getStudentByID(@PathVariable Long studentID, Model model) {
        StudentDTO studentDTO = studentService.getStudentByID(studentID);
        model.addAttribute("student", studentDTO);
        return "student_view";
    }

    // DELETE STUDENT
    @GetMapping("/students/{studentID}/delete")
    public String deleteStudent(@PathVariable Long studentID) {
        studentService.deleteStudent(studentID);
        return "redirect:/students";
    }

    // SEARCHED DATA
    @GetMapping("/students/search")
    public String searchStudentByStudentID(@RequestParam("query") String query, Model model) {
        List<StudentDTO> students = studentService.searchStudentByStudentID(query);
        model.addAttribute("students", students);
//        model.addAttribute("query", query);
        return "students";
    }

}
