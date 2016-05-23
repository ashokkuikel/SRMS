package com.yubaraj.srms.web.DTO;

import com.yubaraj.srms.web.entities.Course;
import com.yubaraj.srms.web.entities.Subject;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
public class SubjectDTO implements Serializable {

    private Long id;
    private String subjectName;
    private List<Subject> subjectList;
    private Character status;
    private Subject subject;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String courseName;
    private Double fullMarks;
    private Double passMarks;
    private List<Course> courseList;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the subjectList
     */
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    /**
     * @param subjectList the subjectList to set
     */
    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    /**
     * @return the status
     */
    public Character getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Character status) {
        this.status = status;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the lastModifiedBy
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy the lastModifiedBy to set
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return the lastModifiedDate
     */
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate the lastModifiedDate to set
     */
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the fullMarks
     */
    public Double getFullMarks() {
        return fullMarks;
    }

    /**
     * @param fullMarks the fullMarks to set
     */
    public void setFullMarks(Double fullMarks) {
        this.fullMarks = fullMarks;
    }

    /**
     * @return the passMarks
     */
    public Double getPassMarks() {
        return passMarks;
    }

    /**
     * @param passMarks the passMarks to set
     */
    public void setPassMarks(Double passMarks) {
        this.passMarks = passMarks;
    }

    /**
     * @return the courseList
     */
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * @param courseList the courseList to set
     */
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
