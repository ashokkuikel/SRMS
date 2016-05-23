package com.yubaraj.srms.web.entities;

import java.io.Serializable;
import java.util.Date;
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
 * @author Yubaraj
 */
@Entity
@Table(name = "application_user")
@NamedQueries({
    @NamedQuery(name = "ApplicationUser.findAll", query = "SELECT a FROM ApplicationUser a"),
    @NamedQuery(name = "ApplicationUser.findAllToView", query = "SELECT a FROM ApplicationUser a where a.userType ='APP_USER' and a.id !=:id and a.status !='D'"),
    @NamedQuery(name = "ApplicationUser.findByUsername", query = "SELECT a from ApplicationUser a WHERE a.username =:username and a.status='A' "),
    @NamedQuery(name = "ApplicationUser.findById", query = "SELECT a from ApplicationUser a WHERE a.id =:id "),
    @NamedQuery(name = "ApplicationUser.findByUsernameAndUserType", query = "SELECT a FROM ApplicationUser a where a.username =:username and a.userType =:userType and a.status !='D' ")
})
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "status")
    private Character status;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "user_type")
    private String userType;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser lastModifiedBy;

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;
    
    @JoinColumn(name = "deleted_by", referencedColumnName = "id")
    @ManyToOne
    private ApplicationUser deletedBy;
    public ApplicationUser() {
    }

    public ApplicationUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public ApplicationUser getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(ApplicationUser lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.yubaraj.srms.core.entity.ApplicationUser[ id=" + id + " ]";
    }

}
