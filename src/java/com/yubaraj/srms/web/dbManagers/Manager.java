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
import java.util.List;

/**
 *
 * @author Yubaraj
 */
public interface Manager {

    public ApplicationUser login(String username, String userType);

    public ApplicationUser createUser(ApplicationUserDTO userDto);

    public Course registerCourse(CourseDTO courseDTO);

    public List<Course> getAllCourseListByActiveStatus();

    public Student registerStudent(com.yubaraj.srms.web.DTO.StudentDto studentDto);

    public Subject registerStudent(SubjectDTO subjectDto);

    public List<Student> getAllStudentByActiveStatus();

    public List<Subject> getAllActiveSubjects();

    public Marks entryMarks(MarksDTO marksDto);

    public Subject getSubjectById(Long subjectId);

    public List<ApplicationUser> getAllApplicationUser();

    public List<Course> getAllCourse();

    public List<Student> getAllStudent();

    public List<Subject> getAllSubject();

    public Student getStudent(Long rollNo);

    public Double getSumOfObtainedMarksByStudentId(Long rollNo);

    public Double getSumOfTotalFullMarksByStudentId(Long rollNo);

    public List<Marks> getMarks(Long rollNo);

    public ApplicationUser getApplicationUserById(Long userId);

    public boolean modifyUser(ApplicationUser user);

    public boolean deleteUser(ApplicationUser user);

    public Course getCourseById(Long id);

    public boolean modifyCourse(Course course);

    public boolean deleteCourse(Course course);

    public Student getStudentById(Long id);

    public boolean modifyStudent(Student student);

    public boolean deleteStudent(Student student);

    public boolean modifySubject(Subject subject);

    public boolean deleteSubject(Subject subject);
}
