package com.sgm.studentgrademanager.mapper;

import com.sgm.studentgrademanager.dto.EnrollmentDTO;
import com.sgm.studentgrademanager.model.EnrollmentModel;

public class EnrollmentMapper {
    public static EnrollmentModel mapToEnrollmentModel (EnrollmentDTO enrollmentDTO) {
        return EnrollmentDTO.builder()
                .enrollmentDate(enrollmentDTO.getEnrollmentDate())
                .semesterName(enrollmentDTO.getSemesterName())
                .status(enrollmentDTO.getStatus())
                .build();
    }

    public static EnrollmentDTO mapToEnrollmentDTO (EnrollmentModel enrollmentModel){
        return (EnrollmentDTO) EnrollmentModel.builder()
                .enrollmentID(enrollmentModel.getEnrollmentID())
                .enrollmentDate(enrollmentModel.getEnrollmentDate())
                .semesterName(enrollmentModel.getSemesterName())
                .status(enrollmentModel.getStatus())
                .build();
    }
}
