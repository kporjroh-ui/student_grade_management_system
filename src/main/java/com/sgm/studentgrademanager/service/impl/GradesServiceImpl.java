package com.sgm.studentgrademanager.service.impl;

import com.sgm.studentgrademanager.dto.GradesDTO;
import com.sgm.studentgrademanager.model.EnrollmentModel;
import com.sgm.studentgrademanager.model.GradesModel;
import com.sgm.studentgrademanager.repository.EnrollmentRepository;
import com.sgm.studentgrademanager.repository.GradesRepository;
import com.sgm.studentgrademanager.service.GradesService;
import org.springframework.stereotype.Service;

import static com.sgm.studentgrademanager.mapper.GradesMapper.mapToGradesModel;

@Service
public class GradesServiceImpl implements GradesService {

    GradesRepository gradesRepository;
    EnrollmentRepository enrollmentRepository;

    public GradesServiceImpl (GradesRepository gradesRepository, EnrollmentRepository enrollmentRepository) {
        this.gradesRepository = gradesRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public void saveGrade (GradesDTO gradesDTO) {
        GradesModel gradesModel = mapToGradesModel(gradesDTO);
        gradesRepository.save (gradesModel);
    }

    @Override
    public void editGrade (GradesDTO gradesDTO) {
        GradesModel gradesModel = mapToGradesModel(gradesDTO);
        gradesRepository.save(gradesModel);
    }

    @Override
    public void recordGrade (Long enrollmentID, GradesDTO gradesDTO) {
        EnrollmentModel enrollmentModel = enrollmentRepository.findById(enrollmentID).get();
        GradesModel gradesModel = mapToGradesModel(gradesDTO);
        gradesModel.setEnrollment(enrollmentModel);
        gradesRepository.save(gradesModel);
    }
}
