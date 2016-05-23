package com.yubaraj.srms.web.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, String> courseName;
	public static volatile SingularAttribute<Course, Date> createdDate;
	public static volatile SingularAttribute<Course, ApplicationUser> createdBy;
	public static volatile SingularAttribute<Course, Date> lastModifiedDate;
	public static volatile SingularAttribute<Course, Date> deletedDate;
	public static volatile SingularAttribute<Course, ApplicationUser> lastModifiedBy;
	public static volatile SingularAttribute<Course, String> description;
	public static volatile SingularAttribute<Course, Long> id;
	public static volatile SingularAttribute<Course, ApplicationUser> deletedBy;
	public static volatile SingularAttribute<Course, Character> status;

}

