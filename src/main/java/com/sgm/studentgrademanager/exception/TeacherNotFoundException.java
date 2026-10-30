package com.sgm.studentgrademanager.exception;

import java.io.Serial;

public class TeacherNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2L;

    public TeacherNotFoundException (String message) {
        super (message);
    }
}
