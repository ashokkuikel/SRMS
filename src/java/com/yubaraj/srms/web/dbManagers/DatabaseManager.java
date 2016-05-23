package com.yubaraj.srms.web.dbManagers;

import com.yubaraj.srms.web.DTO.ApplicationUserDTO;
import com.yubaraj.srms.web.DTO.CourseDTO;
import com.yubaraj.srms.web.DTO.MarksDTO;
import com.yubaraj.srms.web.DTO.SubjectDTO;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.entities.Course;
import com.yubaraj.srms.web.entities.Marks;
import com.yubaraj.srms.web.entities.Student;
import com.yubaraj.srms.web.entities.Subject;
import com.yubaraj.srms.web.utilities.BCrypt;
import com.yubaraj.srms.web.utilities.SRMSConstant;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Yubaraj
 */
public class DatabaseManager implements Manager {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private ApplicationUser applicationUser;

    static {
        emf = DatabaseConnection.getConnection();
    }

    public DatabaseManager() {
    }

    public DatabaseManager(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public ApplicationUser login(String username, String userType) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("ApplicationUser.findByUsernameAndUserType");
            query.setParameter("username", username);
            query.setParameter("userType", userType);
            ApplicationUser applicationUser = (ApplicationUser) query.getSingleResult();
            return applicationUser;
        } catch (NoResultException nre) {
            System.out.println("Username not found: " + username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public ApplicationUser createUser(ApplicationUserDTO userDto) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();

            ApplicationUser user = new ApplicationUser();
            user.setAddress(userDto.getAddress());
            user.setCreatedDate(new Date());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setMiddleName(userDto.getMiddleName());
            user.setMobileNumber(userDto.getMobileNumber());
            user.setPassword(BCrypt.hashpw(user.getFirstName(), BCrypt.gensalt()));
            user.setStatus(userDto.getStatus());
            user.setUserType(SRMSConstant.APP_USER);
            user.setUsername(user.getFirstName());

            em.persist(user);

            entityTransaction.commit();
            System.out.println("User id: " + user.getId());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            em.close();
        }
    }

    @Override
    public Course registerCourse(CourseDTO courseDTO) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();

            Course course = new Course();
            course.setCourseName(courseDTO.getCourseName());
            course.setDescription(courseDTO.getCourseDescription());
            course.setCreatedBy(applicationUser);
            course.setStatus(SRMSConstant.ACTIVE_STATUS);
            course.setCreatedDate(new Date());

            em.persist(course);

            entityTransaction.commit();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            em.close();
        }
    }

    @Override
    public List<Course> getAllCourseListByActiveStatus() {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Course.findByStatus");
            query.setParameter("status", SRMSConstant.ACTIVE_STATUS);
            return (List<Course>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Student registerStudent(com.yubaraj.srms.web.DTO.StudentDto studentDto) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();

            Student student = new Student();
            student.setAddress(studentDto.getAddress());
            student.setCourseName(studentDto.getCourse());
            student.setCreatedBy(applicationUser);
            student.setCreatedDate(new Date());
            student.setDob(studentDto.getDob());
            student.setEmail(studentDto.getEmail());
            student.setFirstName(studentDto.getFirstName());
            student.setMiddleName(studentDto.getMiddleName());
            student.setLastName(studentDto.getLastName());
            student.setGander(studentDto.getGender());
            student.setMobileNumber(studentDto.getMobileNumber());
            student.setSemester(studentDto.getSemester());
            student.setStatus(SRMSConstant.ACTIVE_STATUS);

            em.persist(student);

            entityTransaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            em.close();
        }
    }

    @Override
    public Subject registerStudent(SubjectDTO subjectDto) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();

            Subject subject = new Subject();
            subject.setCourseName(subjectDto.getCourseName());
            subject.setFullMarks(subjectDto.getFullMarks());
            subject.setPassMarks(subjectDto.getPassMarks());
            subject.setSubjectName(subjectDto.getSubjectName());
            subject.setCreatedBy(applicationUser);
            subject.setCreatedDate(new Date());
            subject.setStatus(SRMSConstant.ACTIVE_STATUS);

            em.persist(subject);

            entityTransaction.commit();
            return subject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            em.close();
        }
    }

    @Override
    public List<Student> getAllStudentByActiveStatus() {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Student.findAllByStatus");
            query.setParameter("status", SRMSConstant.ACTIVE_STATUS);
            return (List<Student>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Subject> getAllActiveSubjects() {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Subject.findAllByStatus");
            query.setParameter("status", SRMSConstant.ACTIVE_STATUS);
            return (List<Subject>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Marks entryMarks(MarksDTO marksDto) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();

            Marks marks = new Marks();

            Subject subject = marksDto.getSubject();
            if (subject != null) {
                marks.setFullMarks(subject.getFullMarks());
                marks.setPassMarks(subject.getPassMarks());
            }
            marks.setMarksValue(marksDto.getMarksValue());
            marks.setSubject(subject.getSubjectName());
            marks.setCreatedBy(applicationUser);
            marks.setCreatedDate(new Date());
            marks.setStatus(SRMSConstant.ACTIVE_STATUS);
            marks.setStudentId(marksDto.getStudentId());

            em.persist(marks);

            entityTransaction.commit();
            return marks;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            em.close();
        }
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Subject.findById");
            query.setParameter("id", subjectId);
            return (Subject) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationUser> getAllApplicationUser() {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("ApplicationUser.findAllToView");
            query.setParameter("id", applicationUser.getId());
            return (List<ApplicationUser>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> getAllCourse() {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Course.findAll");
            return (List<Course>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> getAllStudent() {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Student.findAll");
            return (List<Student>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Subject> getAllSubject() {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Subject.findAll");
            return (List<Subject>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student getStudent(Long rollNo) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Student.findAllById");
            query.setParameter("id", rollNo);
            return (Student) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Double getSumOfObtainedMarksByStudentId(Long rollNo) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            String sql = "SELECT SUM(m.marks_value) AS TOTAL FROM marks M WHERE m.student_id =" + rollNo;
            Query query = em.createNativeQuery(sql);
            return (Double) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Double getSumOfTotalFullMarksByStudentId(Long rollNo) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            String sql = "SELECT SUM(m.full_marks) AS TOTAL FROM marks M WHERE m.student_id =" + rollNo;
            Query query = em.createNativeQuery(sql);
            return (Double) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Marks> getMarks(Long rollNo) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Marks.findByStudentId");
            query.setParameter("studentId", rollNo);
            return (List<Marks>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApplicationUser getApplicationUserById(Long userId) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("ApplicationUser.findById");
            query.setParameter("id", userId);

            return (ApplicationUser) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean modifyUser(ApplicationUser user) {
        if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            user.setLastModifiedDate(new Date());
            user.setLastModifiedBy(applicationUser);
            em.merge(user);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(ApplicationUser user) {
        if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            
            user.setStatus(SRMSConstant.DELETED_STATUS);
            user.setDeletedDate(new Date());
            user.setDeletedBy(applicationUser);
            
            em.merge(user);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Course getCourseById(Long id) {
         if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Course.findById");
            query.setParameter("id", id);

            return (Course) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean modifyCourse(Course course) {
        if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            course.setLastModifiedDate(new Date());
            course.setLastModifiedBy(applicationUser);
            em.merge(course);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCourse(Course course) {
        if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            
            course.setStatus(SRMSConstant.DELETED_STATUS);
            course.setDeletedDate(new Date());
            course.setDeletedBy(applicationUser);
            
            em.merge(course);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentById(Long id) {
        if (emf == null) {
            return null;
        }
        em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Student.findById");
            query.setParameter("id", id);

            return (Student) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean modifyStudent(Student student) {
        if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            student.setLastModifiedDate(new Date());
            student.setLastModifiedBy(applicationUser);
            em.merge(student);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(Student student) {
        if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            
            student.setStatus(SRMSConstant.DELETED_STATUS);
            student.setDeletedDate(new Date());
            student.setDeletedBy(applicationUser);
            
            em.merge(student);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifySubject(Subject subject) {
        if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            subject.setLastModifiedDate(new Date());
            subject.setLastModifiedBy(applicationUser);
            em.merge(subject);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSubject(Subject subject) {
       if (emf == null) {
            return false;
        }
        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            
            subject.setStatus(SRMSConstant.DELETED_STATUS);
            subject.setDeletedDate(new Date());
            subject.setDeletedBy(applicationUser);
            
            em.merge(subject);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
