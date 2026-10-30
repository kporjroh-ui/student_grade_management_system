package com.sgm.studentgrademanager.controller;

import com.sgm.studentgrademanager.dto.TeacherDTO;
import com.sgm.studentgrademanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {
    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String teachersList(Model model){
        List<TeacherDTO> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

//    @GetMapping("/teacher/{teacherId}")
//    public ResponseEntity<TeacherService> getTeacherById(@PathVariable Long teacherId) {
//        return ResponseEntity.ok((TeacherService) teacherService.getTeacherById(teacherId));
//    }
//
//    @PostMapping("/teacher/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO ,@Valid) {
//        return new ResponseEntity<>(teacherService.createTeacher(teacherDTO), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/teacher/{teacherID}/update")
//    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO, @PathVariable Long teacherID) {
//        TeacherDTO response = teacherService.updateTeacher(teacherDTO,teacherID);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/teacher/{teacherId}/delete")
//    public ResponseEntity<String> deleteTeacher(@PathVariable Long teacherId) {
//        teacherService.deleteStudent(teacherId);
//        return new ResponseEntity<>("Teacher deleted successfully",HttpStatus.OK);
//    }


}
