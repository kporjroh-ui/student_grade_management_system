package com.sgm.studentgrademanager.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TeacherDTO {
    private Long teacherID;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String department;

}
