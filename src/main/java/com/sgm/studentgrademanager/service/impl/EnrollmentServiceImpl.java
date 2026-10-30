package com.sgm.studentgrademanager.service.impl;

import com.sgm.studentgrademanager.dto.EnrollmentDTO;
import com.sgm.studentgrademanager.model.CourseModel;
import com.sgm.studentgrademanager.model.EnrollmentModel;
import com.sgm.studentgrademanager.model.StudentModel;
import com.sgm.studentgrademanager.repository.CourseRepository;
import com.sgm.studentgrademanager.repository.EnrollmentRepository;
import com.sgm.studentgrademanager.repository.StudentRepository;
import com.sgm.studentgrademanager.service.EnrollmentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    EnrollmentRepository enrollmentRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    public EnrollmentServiceImpl (EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    //enroll in a course
    @Override
    @Transactional
    public EnrollmentModel createEnrollment (EnrollmentDTO enrollmentDTO) {
        if(enrollmentRepository.existsByStudent_StudentIDAndCourse_CourseIDAndSemesterName(enrollmentDTO.getStudentID(), enrollmentDTO.getCourseID(), enrollmentDTO.getSemesterName())) {
           throw new IllegalStateException("Enrollment already exists" + enrollmentDTO.getSemesterName());
        }
        StudentModel student = studentRepository.findById(enrollmentDTO.getStudentID()).orElseThrow( () -> new RuntimeException("Student not found") );
        CourseModel course = courseRepository.findById(enrollmentDTO.getCourseID()).orElseThrow( () -> new RuntimeException("Course not found") );

        EnrollmentModel enrollment = new EnrollmentModel();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setSemesterName(enrollmentDTO.getSemesterName());
        enrollment.setEnrollmentDate(enrollmentDTO.getEnrollmentDate());
        enrollment.setStatus(enrollmentDTO.getStatus());
        return enrollmentRepository.save (enrollment);
    }

    @Override
    public EnrollmentDTO getEnrollmentByID (Long enrollmentID) {
        return null;
    }

    @Override
    public EnrollmentDTO updateStatus (Long enrollmentID, String status) {
        return null;
    }

    @Override
    public List<EnrollmentModel> getEnrollmentsByStudentID (Long studentID) {
        return enrollmentRepository.findByStudent_StudentIDAndStatusNot(studentID, "DROPPED");
    }

}
