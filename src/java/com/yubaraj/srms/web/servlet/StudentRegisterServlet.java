package com.yubaraj.srms.web.servlet;

import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.entities.Student;
import com.yubaraj.srms.web.utilities.ActionUtils;
import com.yubaraj.srms.web.utilities.SRMSConstant;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Yuba Raj Kalathoki
 */
@WebServlet(name = "StudentRegisterServlet", urlPatterns = {"/studentRegisterServlet"})
public class StudentRegisterServlet extends HttpServlet {

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
        com.yubaraj.srms.web.DTO.StudentDto studentDto = new com.yubaraj.srms.web.DTO.StudentDto();

        try {
            BeanUtils.populate(studentDto, request.getParameterMap());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(StudentRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(StudentRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Manager manager = new DatabaseManager(applicationUser);
        Student student = manager.registerStudent(studentDto);
        if (student == null) {
            request.setAttribute(SRMSConstant.ERROR_MESSAGE, "Registration failed!");
        } else {
            request.setAttribute(SRMSConstant.SUCCESS_MESSAGE, "Registered successfully!");
        }
        String page = "studentRegister.jsp";
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
