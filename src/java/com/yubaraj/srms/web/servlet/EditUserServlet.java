package com.yubaraj.srms.web.servlet;

import com.yubaraj.srms.web.DTO.ApplicationUserDTO;
import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.utilities.ActionUtils;
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
@WebServlet(name = "EditUserServlet", urlPatterns = {"/editUserServlet"})
public class EditUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.IllegalAccessException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");

        ApplicationUser applicationUser = (ApplicationUser) request.getSession().getAttribute("applicationUser");
        Manager manager = new DatabaseManager(applicationUser);
        ApplicationUserDTO userDto = new ApplicationUserDTO();

        BeanUtils.populate(userDto, request.getParameterMap());

        ApplicationUser user = manager.getApplicationUserById(userDto.getId());

        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());

        boolean modified = manager.modifyUser(user);

        ActionUtils.processUserModification(request, response, modified);
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
        try {
            processRequest(request, response);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
