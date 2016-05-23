package com.yubaraj.srms.web.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c where c.status !='D'"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c where c.id =:id and c.status !='D'"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c where c.courseName =:courseName"),
    @NamedQuery(name = "Course.findByStatus", query = "SELECT c FROM Course c where c.status =:status")
})
public class Course implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "course_name")
    private String courseName;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser lastModifiedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser createdBy;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "status")
    private Character status;

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @JoinColumn(name = "deleted_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser deletedBy;

    public Course() {
    }

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the lastModifiedBy
     */
    public ApplicationUser getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy the lastModifiedBy to set
     */
    public void setLastModifiedBy(ApplicationUser lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return the createdBy
     */
    public ApplicationUser getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(ApplicationUser createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate the lastModifiedDate to set
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
     * @return the deletedDate
     */
    public Date getDeletedDate() {
        return deletedDate;
    }

    /**
     * @param deletedDate the deletedDate to set
     */
    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    /**
     * @return the deletedBy
     */
    public ApplicationUser getDeletedBy() {
        return deletedBy;
    }

    /**
     * @param deletedBy the deletedBy to set
     */
    public void setDeletedBy(ApplicationUser deletedBy) {
        this.deletedBy = deletedBy;
    }

}
