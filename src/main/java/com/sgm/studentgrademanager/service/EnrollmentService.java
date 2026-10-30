package com.sgm.studentgrademanager.service;

import com.sgm.studentgrademanager.dto.EnrollmentDTO;
import com.sgm.studentgrademanager.model.EnrollmentModel;
import org.springframework.stereotype.Service;


@Service
public interface EnrollmentService {
    EnrollmentModel createEnrollment(EnrollmentDTO enrollmentDTO);
    EnrollmentDTO getEnrollmentByID(Long enrollmentID);
    EnrollmentDTO updateStatus(Long enrollmentID, String status);
    EnrollmentDTO getEnrollmentsByStudentID(Long studentID);
}
