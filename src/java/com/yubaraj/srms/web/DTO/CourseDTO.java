package com.yubaraj.srms.web.DTO;

import java.io.Serializable;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
public class CourseDTO implements Serializable {

    private Long id;
    private String courseDescription;
    private String courseName;
    private Character status;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
    private String statusDetails;

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
     * @return the courseDescription
     */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     * @param courseDescription the courseDescription to set
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
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
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the modifiedDate
     */
    public String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return the statusDetails
     */
    public String getStatusDetails() {
        return statusDetails;
    }

    /**
     * @param statusDetails the statusDetails to set
     */
    public void setStatusDetails(String statusDetails) {
        this.statusDetails = statusDetails;
    }

}
