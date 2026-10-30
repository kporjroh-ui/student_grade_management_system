package com.sgm.studentgrademanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long studentID;
    @NotBlank ( message = "First name cannot be blank")
    private String firstName;
    @NotBlank
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phoneNumber;


}
