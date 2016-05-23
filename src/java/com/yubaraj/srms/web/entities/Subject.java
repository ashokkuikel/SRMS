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

@Entity
@Table(name = "subject")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s where s.status !='D' "),
    @NamedQuery(name = "Subject.findById", query = "SELECT s FROM Subject s where s.id =:id and s.status !='D' "),
    @NamedQuery(name = "Subject.findAllByStatus", query = "SELECT s FROM Subject s where s.status =:status")
})
public class Subject implements Serializable {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "subject_name")
    private String subjectName;
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
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "full_marks")
    private Double fullMarks;
    @Column(name = "pass_marks")
    private Double passMarks;

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @JoinColumn(name = "deleted_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser deletedBy;

    public Subject() {
    }

    public Subject(Long id) {
        this.id = id;
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
