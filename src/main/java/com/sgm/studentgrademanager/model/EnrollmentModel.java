package com.sgm.studentgrademanager.model;

import com.sgm.studentgrademanager.enums.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table (name = "Enrollment_Table")
public class EnrollmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentID;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime enrollmentDate;

    private String semesterName;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    //one student has many enrollments
    @ManyToOne
    @JoinColumn(name="studentID", nullable = false)
    private StudentModel student;

    //one course has many enrollments
    @ManyToOne
    @JoinColumn(name = "courseID",nullable = false)
    private CourseModel course;

    // All the individual grade entries (quizzes, midterms, etc.) for this enrollment
    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GradesModel> grades;

}
