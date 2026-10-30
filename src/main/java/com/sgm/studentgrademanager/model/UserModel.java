package com.sgm.studentgrademanager.model;

import com.sgm.studentgrademanager.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User_Table")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String userPassword;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = "studentID")
    private StudentModel student;

    @OneToOne
    @JoinColumn(name = "teacherID")
    private TeacherModel teacher;

}