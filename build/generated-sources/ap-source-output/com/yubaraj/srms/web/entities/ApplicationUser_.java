package com.yubaraj.srms.web.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ApplicationUser.class)
public abstract class ApplicationUser_ {

	public static volatile SingularAttribute<ApplicationUser, String> lastName;
	public static volatile SingularAttribute<ApplicationUser, Date> lastLogin;
	public static volatile SingularAttribute<ApplicationUser, String> address;
	public static volatile SingularAttribute<ApplicationUser, Date> lastModifiedDate;
	public static volatile SingularAttribute<ApplicationUser, String> mobileNumber;
	public static volatile SingularAttribute<ApplicationUser, ApplicationUser> lastModifiedBy;
	public static volatile SingularAttribute<ApplicationUser, ApplicationUser> deletedBy;
	public static volatile SingularAttribute<ApplicationUser, String> firstName;
	public static volatile SingularAttribute<ApplicationUser, String> password;
	public static volatile SingularAttribute<ApplicationUser, Date> createdDate;
	public static volatile SingularAttribute<ApplicationUser, Date> deletedDate;
	public static volatile SingularAttribute<ApplicationUser, String> middleName;
	public static volatile SingularAttribute<ApplicationUser, Long> id;
	public static volatile SingularAttribute<ApplicationUser, String> userType;
	public static volatile SingularAttribute<ApplicationUser, String> email;
	public static volatile SingularAttribute<ApplicationUser, String> username;
	public static volatile SingularAttribute<ApplicationUser, Character> status;

}

