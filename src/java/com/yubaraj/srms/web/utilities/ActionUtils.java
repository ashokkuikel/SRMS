package com.yubaraj.srms.web.utilities;

import com.yubaraj.srms.web.DTO.ApplicationUserDTO;
import com.yubaraj.srms.web.DTO.CourseDTO;
import com.yubaraj.srms.web.DTO.SubjectDTO;
import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.entities.Course;
import com.yubaraj.srms.web.entities.Student;
import com.yubaraj.srms.web.entities.Subject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yuba Raj Kalathoki
 */
public class ActionUtils {

    public static List<Course> getCourse(HttpServletRequest request) {
        ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
        Manager manager = new DatabaseManager(applicationUser);
        List<Course> courseList = manager.getAllCourseListByActiveStatus();
        return courseList;
    }

    public static void sendRequest(HttpServletRequest request, HttpServletResponse response, String page) {
        try {
            request.setAttribute(SRMSConstant.CONTENT, page);
            request.getRequestDispatcher("./pages/mainContent.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ActionUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<ApplicationUserDTO> getAllApplicationUserDtoList(HttpServletRequest request, HttpServletResponse response) {
        ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
        Manager manager = new DatabaseManager(applicationUser);
        List<ApplicationUser> userList = manager.getAllApplicationUser();
        List<ApplicationUserDTO> userDtoList = new ArrayList<>();
        for (ApplicationUser user : userList) {
            ApplicationUserDTO userDto = new ApplicationUserDTO();
            userDto.setFullName(user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName());
            userDto.setId(user.getId());
            userDto.setAddress(user.getAddress());
            userDto.setEmail(user.getEmail());
            userDto.setLastLogin(DateFormatter.getDate(user.getLastLogin(), SRMSConstant.DATE_FORMAT));
            userDto.setMobileNumber(user.getMobileNumber());
            userDto.setStatus(user.getStatus());
            userDto.setUsername(user.getUsername());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public static void processUserModification(HttpServletRequest request, HttpServletResponse response, boolean modified) {
        String page;
        if (!modified) {
            request.setAttribute(SRMSConstant.ERROR_MESSAGE, "User modification failed!");
//            request.setAttribute("action",modified);
            page = "editUser.jsp";
        } else {
            request.setAttribute(SRMSConstant.SUCCESS_MESSAGE, "User modifed successfully!");
            page = "viewUser.jsp";
        }
        List<ApplicationUserDTO> userDtoList = ActionUtils.getAllApplicationUserDtoList(request, response);

        request.setAttribute("userList", userDtoList);
        ActionUtils.sendRequest(request, response, page);
    }

    public static boolean validateUserToRegister(ApplicationUserDTO userDto) {
        if (userDto.getFirstName().equalsIgnoreCase("") || userDto.getLastName().equalsIgnoreCase("") || userDto.getAddress().equalsIgnoreCase("") || userDto.getMobileNumber().equalsIgnoreCase("") || userDto.getEmail().equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

//    public static void processCourseModification(HttpServletRequest request, HttpServletResponse response, boolean modified) {
//        String page;
//        if (!modified) {
//            request.setAttribute(SRMSConstant.ERROR_MESSAGE, "Course modification failed!");
////            request.setAttribute("action",modified);
//            page = "editCourse.jsp";
//        } else {
//            request.setAttribute(SRMSConstant.SUCCESS_MESSAGE, "Course modifed successfully!");
//            page = "viewCourse.jsp";
//        }
//        viewCourse(request, response);
//    }
    public static void viewCourse(HttpServletRequest request, HttpServletResponse response) {
        ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
        Manager manager = new DatabaseManager(applicationUser);
        List<Course> courseList = manager.getAllCourse();
        List<CourseDTO> courseDtoList = new ArrayList<>();
        for (Course course : courseList) {
            CourseDTO courseDto = new CourseDTO();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setCourseDescription(course.getDescription());
            courseDto.setStatus(course.getStatus());
            courseDtoList.add(courseDto);
        }
        request.setAttribute("courseDtoList", courseDtoList);
        ActionUtils.sendRequest(request, response, "viewCourse.jsp");
    }

    public static void viewStudent(HttpServletRequest request, HttpServletResponse response) {
        ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
        Manager manager = new DatabaseManager(applicationUser);
        List<Student> studentList = manager.getAllStudent();
        List<com.yubaraj.srms.web.DTO.StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : studentList) {
            com.yubaraj.srms.web.DTO.StudentDto studentDto = new com.yubaraj.srms.web.DTO.StudentDto();
            studentDto.setFullName(student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName());
            studentDto.setId(student.getId());
            studentDto.setAddress(student.getAddress());
            studentDto.setEmail(student.getEmail());
            studentDto.setMobileNumber(student.getMobileNumber());
            studentDto.setStatus(student.getStatus());
            studentDto.setCourse(student.getCourseName());
            studentDto.setSemester(student.getSemester());
            studentDtoList.add(studentDto);
        }
        request.setAttribute("studentList", studentDtoList);
        ActionUtils.sendRequest(request, response, "viewStudent.jsp");
    }

    public static void viewSubject(HttpServletRequest request, HttpServletResponse response) {
         ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
        Manager manager = new DatabaseManager(applicationUser);
        List<Subject> subjectList = manager.getAllSubject();
        List<SubjectDTO> subjectDtoList = new ArrayList<>();
        for (Subject subject : subjectList) {
            SubjectDTO subjectDto = new SubjectDTO();
            subjectDto.setId(subject.getId());
            subjectDto.setSubjectName(subject.getSubjectName());
            subjectDto.setFullMarks(subject.getFullMarks());
            subjectDto.setPassMarks(subject.getPassMarks());
            subjectDto.setCourseName(subject.getCourseName());
            subjectDto.setStatus(subject.getStatus());
            subjectDtoList.add(subjectDto);
        }
        request.setAttribute("subjectDtoList", subjectDtoList);
        ActionUtils.sendRequest(request, response, "viewSubject.jsp");
    }
}
