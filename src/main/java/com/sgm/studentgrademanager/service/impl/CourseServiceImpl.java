package com.sgm.studentgrademanager.service.impl;

import com.sgm.studentgrademanager.dto.CourseDTO;
import com.sgm.studentgrademanager.model.CourseModel;
import com.sgm.studentgrademanager.repository.CourseRepository;
import com.sgm.studentgrademanager.service.CourseService;
import org.springframework.stereotype.Service;
import com.sgm.studentgrademanager.mapper.CoursesMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl (CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAllCourses () {
        List<CourseModel> courses = courseRepository.findAll();
        return courses.stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }
}
