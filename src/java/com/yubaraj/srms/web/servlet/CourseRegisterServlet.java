package com.yubaraj.srms.web.servlet;

import com.yubaraj.srms.web.DTO.CourseDTO;
import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.entities.Course;
import com.yubaraj.srms.web.utilities.ActionUtils;
import com.yubaraj.srms.web.utilities.SRMSConstant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yuba Raj Kalathoki
 */
@WebServlet(name = "CourseRegisterServlet", urlPatterns = {"/courseRegisterServlet"})
public class CourseRegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(request.getParameter("courseName"));
        courseDTO.setCourseDescription(request.getParameter("courseDescription"));
        Manager manager = new DatabaseManager(applicationUser);

        if (courseDTO.getCourseName().length() > 0) {
            Course course = manager.registerCourse(courseDTO);
            if (course == null) {
                request.setAttribute(SRMSConstant.ERROR_MESSAGE, "Registration failed!");
            } else {
                request.setAttribute(SRMSConstant.SUCCESS_MESSAGE, "Registered successfully!");
            }
        } else {
            request.setAttribute(SRMSConstant.ERROR_MESSAGE, "Course Name Required!");
        }
        String page = "courseRegister.jsp";
        ActionUtils.sendRequest(request, response, page);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
