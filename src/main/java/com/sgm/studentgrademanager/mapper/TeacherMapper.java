package com.sgm.studentgrademanager.mapper;

import com.sgm.studentgrademanager.dto.TeacherDTO;
import com.sgm.studentgrademanager.model.TeacherModel;

public class TeacherMapper {
    public static TeacherDTO mapToTeacherDTO (TeacherModel teacherModel){
        return TeacherDTO.builder()
                .teacherID(teacherModel.getTeacherID())
                .firstName(teacherModel.getFirstName())
                .lastName(teacherModel.getLastName())
                .department(teacherModel.getDepartment())
                .email(teacherModel.getEmail())
                .build();
    }

    public static TeacherModel mapToTeacherModel (TeacherDTO teacherDTO){
        return TeacherModel.builder()
                .teacherID(teacherDTO.getTeacherID())
                .firstName(teacherDTO.getFirstName())
                .lastName(teacherDTO.getLastName())
                .department(teacherDTO.getDepartment())
                .email(teacherDTO.getEmail())
                .build();
    }
}
