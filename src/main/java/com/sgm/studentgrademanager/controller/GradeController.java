package com.sgm.studentgrademanager.controller;

import com.sgm.studentgrademanager.dto.CourseDTO;
import com.sgm.studentgrademanager.dto.GradesDTO;
import com.sgm.studentgrademanager.enums.AssessmentType;
import com.sgm.studentgrademanager.model.CourseModel;
import com.sgm.studentgrademanager.model.EnrollmentModel;
import com.sgm.studentgrademanager.model.GradesModel;
import com.sgm.studentgrademanager.model.StudentModel;
import com.sgm.studentgrademanager.service.GradesService;
import jakarta.validation.Valid;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GradeController {

    GradesService gradesService;

    public GradeController(GradesService gradesService) {
        this.gradesService = gradesService;
    }

    @GetMapping("/grade_entry_form/{enrollmentID}/new")
    public String recordGrade (@PathVariable Long enrollmentID, Model model){
        GradesModel gradesModel = new GradesModel();
        EnrollmentModel enrollmentModel = new EnrollmentModel();
        model.addAttribute("gradesModel", gradesModel);
        model.addAttribute("assessmentTypes", AssessmentType.values());
        model.addAttribute("enrollmentModel", enrollmentModel);
        return "grade_entry_form";
    }

    @PostMapping("/grade_entry_form")
    public String saveGrade (@Valid @ModelAttribute("gradesModel") GradesDTO gradesDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("gradesModel", gradesDTO);
            return "grade_entry_form";
        }
        gradesService.saveGrade(gradesDTO);
        return "redirect:/grade_entry_form";
    }

    @PostMapping("/grades/{gradeID}/edit")
    public String editGrade (@PathVariable Long gradeID, @Valid @ModelAttribute("gradesModel") GradesDTO gradesDTO, BindingResult result){
        if (result.hasErrors()){
            return "grade_entry_form";
        }
        gradesDTO.setGradeID(gradeID);
        gradesService.editGrade(gradesDTO);
        return "redirect:/grade_entry_form";
    }


}
