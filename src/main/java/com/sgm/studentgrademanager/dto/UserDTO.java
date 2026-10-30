package com.sgm.studentgrademanager.dto;

import com.sgm.studentgrademanager.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long userID;
    private String userName;
    private String userPassword;
    private UserRole userRole;
}
