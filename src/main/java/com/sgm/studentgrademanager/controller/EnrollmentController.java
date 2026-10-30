package com.sgm.studentgrademanager.controller;

import com.sgm.studentgrademanager.dto.EnrollmentDTO;
import com.sgm.studentgrademanager.service.CourseService;
import com.sgm.studentgrademanager.service.EnrollmentService;
import com.sgm.studentgrademanager.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;

@Controller
public class EnrollmentController {

    private EnrollmentService enrollmentService;
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentController(EnrollmentService enrollmentService, StudentService studentService, CourseService courseService) {
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // The enrollment page for one student
    @GetMapping("/enrollments/{studentID}/new")
    public String getEnrollmentPage (@PathVariable Long studentID, Model model) {
        model.addAttribute("student", studentService.getStudentByID(studentID));
        model.addAttribute("enrollments", enrollmentService.getEnrollmentByID(studentID) );
        model.addAttribute("courses", courseService.getAllCourses());
        return "enrollment_page";
    }

    // Create enrollment (enroll button)
    @PostMapping("/enrollment/{studentID}/enroll")
    public String createEnrollment (@Valid @ModelAttribute("enrollmentDTO") EnrollmentDTO enrollmentDTO, BindingResult result, Model model, RedirectAttributes ra) {
        Long studentID = enrollmentDTO.getStudentID();

        if(result.hasErrors()) {
            ra.addFlashAttribute ("Error", "Please fill in all required fields");
            return "redirect:/enrollments/" + studentID + "/new";
        }
        try{
            enrollmentService.createEnrollment(enrollmentDTO);
            ra.addFlashAttribute("Success", "Enrollment created successfully");
        } catch (IllegalStateException e) {
                ra.addFlashAttribute("Error", e.getMessage());
            }
        return "student_view";
        //return "redirect:/enrollments/" + studentID + "/new";
    }

    //Drop button
    @PostMapping("/{studentID}/drop/{enrollmentID}")
    public String dropEnrollment (@PathVariable Long studentID, @PathVariable Long enrollmentID, RedirectAttributes ra) {
        enrollmentService.updateStatus(enrollmentID, "Dropped");
        ra.addFlashAttribute("Success", "Enrollment dropped successfully");
        return "redirect:/enrollments/" + studentID + "/new";
    }







}
