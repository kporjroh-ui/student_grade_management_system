package com.sgm.studentgrademanager.mapper;

import com.sgm.studentgrademanager.dto.StudentDTO;
import com.sgm.studentgrademanager.model.StudentModel;

public class StudentMapper {
    public static StudentDTO mapToStudentDTO (StudentModel studentModel) {

        return StudentDTO.builder()
                .studentID(studentModel.getStudentID())
                .firstName(studentModel.getFirstName())
                .lastName(studentModel.getLastName())
                .email(studentModel.getEmail())
                .phoneNumber(studentModel.getPhoneNumber())
                .build();
    }

    public static StudentModel mapToStudentModel (StudentDTO studentDTO){
        return StudentModel.builder()
                .studentID(studentDTO.getStudentID())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail())
                .phoneNumber(studentDTO.getPhoneNumber())
                .build();
    }

}
