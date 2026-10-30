package com.sgm.studentgrademanager.dto;

import com.sgm.studentgrademanager.enums.AssessmentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class GradesDTO {
    private Long gradeID;

    @NotNull ( message = "Assessment type cannot be blank")
    private AssessmentType assessmentType;
    @NotNull ( message = "Score cannot be null")
    private Double score;
    @NotNull ( message = "Weight cannot be null")
    private Double weight;
    @NotNull ( message = "Max score cannot be null")
    private Double maxScore;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull ( message = "Assessment date cannot be empty")
    private LocalDate assessmentDate;

    @NotBlank ( message = "Comments cannot be blank")
    private String comments;
}
