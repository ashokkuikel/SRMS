package com.yubaraj.srms.web.utilities;

import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.entities.Course;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yuba Raj Kalathoki
 * @since 0.0.1
 */
public class SessionUtils {

    public static ApplicationUser getApplicationUserFromSession(HttpServletRequest request) {
        return (ApplicationUser) request.getSession().getAttribute("applicationUser");
    }

//    public static List<Course> getCourseListFromSession(HttpServletRequest request) {
//
//        ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
//        Manager manager = new DatabaseManager(applicationUser);
//        List<Course> courseList = (List<Course>) request.getSession().getAttribute("courseList");
//        if (courseList == null) {
//            courseList = manager.getAllCourseListByActiveStatus();
//            request.setAttribute("courseList", courseList);
//        }
//        return courseList;
//    }

}
