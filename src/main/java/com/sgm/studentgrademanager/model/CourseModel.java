package com.sgm.studentgrademanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table (name = "Courses_table")
public class CourseModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long courseID;

    @Column(nullable = false, unique = true)
    private String courseName;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String courseDescription;

    @Column(nullable = false)
    private Integer courseCreditHours;


    //many courses can be taken by many students
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollmentModel> enrollment;

    //one teacher can teach many courses
    @ManyToOne
    @JoinColumn(name = "teacherID")
    private TeacherModel teacher;



}
