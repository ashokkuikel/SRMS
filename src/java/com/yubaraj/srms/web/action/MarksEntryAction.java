package com.yubaraj.srms.web.action;

import com.yubaraj.srms.web.DTO.StudentItem;
import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.entities.Student;
import com.yubaraj.srms.web.entities.Subject;
import com.yubaraj.srms.web.utilities.ActionUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yuba Raj Kalathoki
 */
@WebServlet(name = "MarksEntryAction", urlPatterns = {"/marksEntryAction"})
public class MarksEntryAction extends HttpServlet {

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
        Manager manager = new DatabaseManager(applicationUser);
        List<Student> studentList = manager.getAllStudentByActiveStatus();

        List<StudentItem> studentItems = new ArrayList<StudentItem>();
        for (Student student : studentList) {
            StudentItem studentItem = new StudentItem();
            studentItem.setStudentId(student.getId());
            studentItem.setStudentName(student.getId().toString()+" ["+student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName()+"]");
            studentItems.add(studentItem);
        }
        request.setAttribute("studentItem", studentItems);

        List<Subject> subjectList = manager.getAllActiveSubjects();
        request.setAttribute("subjectList", subjectList);

        ActionUtils.sendRequest(request, response, "marksEntry.jsp");
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
