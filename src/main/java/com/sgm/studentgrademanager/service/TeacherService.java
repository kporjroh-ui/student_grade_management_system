package com.sgm.studentgrademanager.service;

import com.sgm.studentgrademanager.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<TeacherDTO> getAllTeachers ();
//    TeacherDTO getTeacherById (Long teacherId);
//    TeacherDTO createTeacher (TeacherDTO teacherDTO);
//    TeacherDTO updateTeacher (TeacherDTO teacherDTO, Long teacherID);
//    void deleteStudent (Long teacherId);
}
