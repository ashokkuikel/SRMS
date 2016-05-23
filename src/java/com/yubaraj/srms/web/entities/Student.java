package com.yubaraj.srms.web.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s where s.status !='D' "),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s where s.id =:id and s.status !='D' "),
    @NamedQuery(name = "Student.findAllByStatus", query = "SELECT s FROM Student s where s.status =:status"),
    @NamedQuery(name = "Student.findAllById", query = "SELECT s FROM Student s where s.id =:id")
})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "status")
    private Character status;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "address")
    private String address;
    @Column(name = "parents_full_name")
    private String parentsFullName;
    @Column(name = "parents_address")
    private String parentsAddress;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "relation")
    private String relation;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser lastModifiedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser createdBy;
    @Column(name = "gander")
    private Character gander;
    @Column(name = "dob")
    private String dob;
    @Column(name = "semester")
    private Integer semester;
    @Column(name = "parent_contact_no")
    private String parentContactNo;
    @Column(name = "parent_email")
    private String parentEmail;

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @JoinColumn(name = "deleted_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser deletedBy;
    
    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentsFullName() {
        return parentsFullName;
    }

    public void setParentsFullName(String parentsFullName) {
        this.parentsFullName = parentsFullName;
    }

    public String getParentsAddress() {
        return parentsAddress;
    }

    public void setParentsAddress(String parentsAddress) {
        this.parentsAddress = parentsAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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

    public Character getGander() {
        return gander;
    }

    public void setGander(Character gander) {
        this.gander = gander;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getParentContactNo() {
        return parentContactNo;
    }

    public void setParentContactNo(String parentContactNo) {
        this.parentContactNo = parentContactNo;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public ApplicationUser getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(ApplicationUser deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String toString() {
        return "com.yubaraj.sms.entities.Student[ id=" + id + " ]";
    }
}
