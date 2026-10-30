package com.sgm.studentgrademanager.mapper;

import com.sgm.studentgrademanager.dto.GradesDTO;
import com.sgm.studentgrademanager.model.GradesModel;

public class GradesMapper {

    public static GradesDTO mapToGradesDTO (GradesModel gradesModel) {

        return GradesDTO.builder()
                .gradeID(gradesModel.getGradeID())
                .assessmentType(gradesModel.getAssessmentType())
                .score (gradesModel.getScore())
                .maxScore (gradesModel.getMaxScore ())
                .assessmentDate (gradesModel.getAssessmentDate ())
                .weight(gradesModel.getWeight ())
                .comments (gradesModel.getComments ())
                .build();
    }

    public static GradesModel mapToGradesModel (GradesDTO gradesDTO){

        return GradesModel.builder()
                .gradeID(gradesDTO.getGradeID())
                .assessmentType(gradesDTO.getAssessmentType())
                .score (gradesDTO.getScore())
                .maxScore (gradesDTO.getMaxScore ())
                .assessmentDate (gradesDTO.getAssessmentDate ())
                .weight(gradesDTO.getWeight ())
                .comments (gradesDTO.getComments ())
                .build();
    }
}
