package com.sgm.studentgrademanager.controller;

import com.sgm.studentgrademanager.service.GradesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class GradeBookController {

    GradesService gradesService;

    public GradeBookController(GradesService gradesService) {
        this.gradesService = gradesService;
    }

    @GetMapping("{gradesId}")
    public void viewGradeBook (){

    }

    @PostMapping
    public void submitGradeBook (){

    }

}
