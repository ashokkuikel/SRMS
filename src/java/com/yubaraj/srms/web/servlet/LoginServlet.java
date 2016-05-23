package com.yubaraj.srms.web.servlet;

import com.yubaraj.srms.web.DTO.LoginDTO;
import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.utilities.SRMSConstant;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.utilities.ActionUtils;
import com.yubaraj.srms.web.utilities.BCrypt;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yubaraj
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

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
        LoginDTO loginDto = new LoginDTO();
        response.setContentType("text/html;charset=UTF-8");
        loginDto.setUsername(request.getParameter("username"));
        loginDto.setPassword(request.getParameter("password"));
        loginDto.setUserType(request.getParameter("userType"));
        boolean valid = true;
        if (loginDto.getUsername() == null || loginDto.getUsername().length() < 1) {
            request.setAttribute(SRMSConstant.USERNAME_REQUIRED, "Username required.");
            valid = false;
        }
        if (loginDto.getPassword() == null || loginDto.getPassword().length() < 1) {
            request.setAttribute(SRMSConstant.PASSWORD_REQUIRED, "Password required.");
            valid = false;
        }
        if (loginDto.getUserType() == null) {
            request.setAttribute(SRMSConstant.USER_TYPE_REQUIRED, "User type required.");
            valid = false;
        }
        Manager manager = new DatabaseManager();
        ApplicationUser applicationUser = manager.login(loginDto.getUsername(), loginDto.getUserType());
        if (applicationUser == null) {
            request.setAttribute(SRMSConstant.ERROR_MESSAGE, "Invalid username.");
            valid = false;
        } else {
            valid = BCrypt.checkpw(loginDto.getPassword(), applicationUser.getPassword());
            if (!valid) {
                request.setAttribute(SRMSConstant.ERROR_MESSAGE, "Invalid password.");
            }
        }
        if (!valid) {
            request.setAttribute("username", loginDto.getUsername());
            request.setAttribute("password", loginDto.getPassword());
            doGet(request, response);
        } else {
            String fullName = applicationUser.getFirstName() + " " + applicationUser.getMiddleName() + " " + applicationUser.getLastName();
//            request.setAttribute("fullName", fullName);
            request.getSession().setAttribute("fullName", fullName);
            request.getSession().setAttribute("applicationUser", applicationUser);
            String page="welcome.jsp";
            ActionUtils.sendRequest(request,response, page);
        }
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
        request.getRequestDispatcher("./index.jsp").forward(request, response);
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
