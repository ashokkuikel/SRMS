package com.yubaraj.srms.web.DTO;

import com.yubaraj.srms.web.entities.Marks;
import com.yubaraj.srms.web.entities.Subject;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
public class ResultsDTO {

    private Marks marks;
    private Long studentId;
    private Double fullMarks;
    private Double passMarks;
    private Double marksValue;
    private String result;
    private Double percentage;
    private Subject subject;
    private char grade;
    private String subjectName;

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Double getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(Double fullMarks) {
        this.fullMarks = fullMarks;
    }

    public Double getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(Double passMarks) {
        this.passMarks = passMarks;
    }

    public Double getMarksValue() {
        return marksValue;
    }

    public void setMarksValue(Double marksValue) {
        this.marksValue = marksValue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
