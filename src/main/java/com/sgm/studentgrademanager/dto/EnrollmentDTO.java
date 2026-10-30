package com.sgm.studentgrademanager.dto;

import com.sgm.studentgrademanager.enums.EnrollmentStatus;
import com.sgm.studentgrademanager.model.EnrollmentModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class EnrollmentDTO extends EnrollmentModel {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime enrollmentDate;

    @NotBlank( message = "Course name cannot be blank")
    private String semesterName;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    @NotNull( message = "Student ID cannot be null")
    private Long studentID;

    @NotNull( message = "Course ID cannot be null")
    private Long courseID;
}
