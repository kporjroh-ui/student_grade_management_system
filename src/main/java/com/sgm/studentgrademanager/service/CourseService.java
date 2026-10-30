package com.sgm.studentgrademanager.service;

import com.sgm.studentgrademanager.dto.CourseDTO;
import com.sgm.studentgrademanager.model.CourseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<CourseDTO> getAllCourses();

}
