package com.yubaraj.srms.web.DTO;

import com.yubaraj.srms.web.entities.Subject;
import java.io.Serializable;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
public class MarksDTO implements Serializable {

    private Long id;
    private Long studentId;
    private Long studentRollNumber;
    private Subject subject;
    private Double marksValue;
    private Character status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(Long studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Double getMarksValue() {
        return marksValue;
    }

    public void setMarksValue(Double marksValue) {
        this.marksValue = marksValue;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
