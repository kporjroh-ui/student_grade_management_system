package com.sgm.studentgrademanager.service.impl;

import com.sgm.studentgrademanager.dto.TeacherDTO;
import com.sgm.studentgrademanager.exception.TeacherNotFoundException;
import com.sgm.studentgrademanager.model.TeacherModel;
import com.sgm.studentgrademanager.repository.TeacherRepository;
import com.sgm.studentgrademanager.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherDTO> getAllTeachers () {
        List<TeacherModel> teachers = teacherRepository.findAll();
        return teachers.stream().map(this::mapToTeacherDTO).collect(Collectors.toList());
    }


}
