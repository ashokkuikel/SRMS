package com.yubaraj.srms.web.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Marks.class)
public abstract class Marks_ {

	public static volatile SingularAttribute<Marks, Long> studentId;
	public static volatile SingularAttribute<Marks, Double> marksValue;
	public static volatile SingularAttribute<Marks, Double> fullMarks;
	public static volatile SingularAttribute<Marks, Double> passMarks;
	public static volatile SingularAttribute<Marks, Date> createdDate;
	public static volatile SingularAttribute<Marks, ApplicationUser> createdBy;
	public static volatile SingularAttribute<Marks, Date> lastModifiedDate;
	public static volatile SingularAttribute<Marks, String> subject;
	public static volatile SingularAttribute<Marks, ApplicationUser> lastModifiedBy;
	public static volatile SingularAttribute<Marks, Long> id;
	public static volatile SingularAttribute<Marks, Character> status;

}

