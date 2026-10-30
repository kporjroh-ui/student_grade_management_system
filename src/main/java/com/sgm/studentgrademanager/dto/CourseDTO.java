package com.sgm.studentgrademanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
        private Long courseID;
        @NotBlank
        private String courseName;
        @NotBlank
        private String courseCode;
        @NotBlank
        private String courseDescription;
        @NotBlank
        private Integer courseCreditHours;
    }
