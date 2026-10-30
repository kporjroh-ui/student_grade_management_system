package com.sgm.studentgrademanager.service;

import com.sgm.studentgrademanager.dto.GradesDTO;
import com.sgm.studentgrademanager.model.GradesModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradesService {
    void saveGrade(GradesDTO gradesDTO);
    void editGrade (@Valid GradesDTO gradesDTO);
    void recordGrade(Long enrollmentID, GradesDTO gradesDTO);
}

