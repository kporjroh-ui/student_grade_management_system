package com.sgm.studentgrademanager.mapper;

import com.sgm.studentgrademanager.dto.CourseDTO;
import com.sgm.studentgrademanager.model.CourseModel;

public class CoursesMapper {
    public static CourseDTO mapToCourseDTO (CourseModel courseModel) {
        return CourseDTO.builder()
                .courseID(courseModel.getCourseID())
                .courseCode(courseModel.getCourseCode())
                .courseCreditHours(courseModel.getCourseCreditHours())
                .courseDescription(courseModel.getCourseDescription())
                .courseName(courseModel.getCourseName())
                .build();
    }

    public static CourseModel mapToCourseModel (CourseDTO courseDTO) {
        return CourseModel.builder()
                .courseID(courseDTO.getCourseID())
                .courseCode(courseDTO.getCourseCode())
                .courseCreditHours(courseDTO.getCourseCreditHours())
                .courseDescription(courseDTO.getCourseDescription())
                .courseName(courseDTO.getCourseName())
                .build();
    }
}
