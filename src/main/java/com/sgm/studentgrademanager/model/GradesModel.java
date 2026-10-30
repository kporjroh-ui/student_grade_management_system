package com.sgm.studentgrademanager.model;

import com.sgm.studentgrademanager.enums.AssessmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Grades_Table")
public class GradesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeID;
    @Enumerated(EnumType.STRING)
    private AssessmentType assessmentType;
    private double maxScore;
    private double score;
    private LocalDate assessmentDate;
    private double weight;
    private String comments;

    //many grades per enrollment
    @ManyToOne
    @JoinColumn(name = "enrollmentID",  nullable = false)
    private EnrollmentModel enrollment;

}


