package com.yubaraj.srms.web.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subject.class)
public abstract class Subject_ {

	public static volatile SingularAttribute<Subject, String> courseName;
	public static volatile SingularAttribute<Subject, Double> fullMarks;
	public static volatile SingularAttribute<Subject, Double> passMarks;
	public static volatile SingularAttribute<Subject, Date> createdDate;
	public static volatile SingularAttribute<Subject, ApplicationUser> createdBy;
	public static volatile SingularAttribute<Subject, Date> lastModifiedDate;
	public static volatile SingularAttribute<Subject, ApplicationUser> lastModifiedBy;
	public static volatile SingularAttribute<Subject, Long> id;
	public static volatile SingularAttribute<Subject, String> subjectName;
	public static volatile SingularAttribute<Subject, Character> status;

}

