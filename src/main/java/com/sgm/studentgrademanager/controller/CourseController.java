package com.sgm.studentgrademanager.controller;

import com.sgm.studentgrademanager.dto.CourseDTO;
import com.sgm.studentgrademanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<CourseDTO> courses = courseService.getAllCourses ();
        model.addAttribute("courses", courses);
        return "courses";
    }

//    @GetMapping("{courseId}")
//    public String getCourseById(Model model, @PathVariable String courseId) {
//        String courseName = courseService.getCourseById(1L).getCourseName();
//        model.addAttribute("courseName", courseName);
//        return "manage_courses";
//    }
//
//    @PostMapping
//    public String createCourse() {
//        return null;
//    }
//
//    @DeleteMapping("{courseId}")
//    public void deleteCourse(Model model,@PathVariable String courseId) {
//    }
//
//    @PutMapping("{courseId}")
//    public String updateCourse(Model model,@PathVariable String courseId){
//        return null;
//    }
//
//    @PatchMapping()
//    public String assignTeacher(){
//        return null;
//    }
}
