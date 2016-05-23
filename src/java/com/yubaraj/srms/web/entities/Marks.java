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
@Table(name = "marks")
@NamedQueries({
    @NamedQuery(name = "Marks.findAll", query = "SELECT m FROM Marks m"),
    @NamedQuery(name = "Marks.findByStudentId", query = "SELECT m FROM Marks m where m.studentId =:studentId")
})
public class Marks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "marks_value")
    private Double marksValue;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser lastModifiedBy;
    @Basic(optional = false)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser createdBy;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "status")
    private Character status;
    @Basic(optional = false)
    @Column(name = "student_id")
    private Long studentId;
    @Basic(optional = false)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @Column(name = "full_marks")
    private Double fullMarks;
    @Basic(optional = false)
    @Column(name = "pass_marks")
    private Double passMarks;

    public Marks() {
    }

    public Marks(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMarksValue() {
        return marksValue;
    }

    public void setMarksValue(Double marksValue) {
        this.marksValue = marksValue;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ApplicationUser getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(ApplicationUser lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public ApplicationUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ApplicationUser createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

}
