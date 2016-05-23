package com.yubaraj.srms.web.servlet;

import com.yubaraj.srms.web.DTO.ApplicationUserDTO;
import com.yubaraj.srms.web.utilities.WriteExcelForApplicationUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.write.WriteException;

/**
 *
 * @author Yuba Raj Kalathoki
 */
@WebServlet(name = "UserRecordDumpServlet", urlPatterns = {"/userRecordDumpServlet"})
public class UserRecordDumpServlet extends HttpServlet {

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

        List<ApplicationUserDTO> applicationUserList = (List<ApplicationUserDTO>) request.getSession().getAttribute("userDtoList");

        try {
            List<ApplicationUserDTO> excelPojoList = new ArrayList<ApplicationUserDTO>();
            if (applicationUserList.isEmpty()) {
                System.out.println("Sorry no record to dump.");
            } else {
                for (ApplicationUserDTO obj : applicationUserList) {
                    ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();
                    applicationUserDTO.setFullName(obj.getFullName());
                    applicationUserDTO.setMobileNumber(obj.getMobileNumber());
                    applicationUserDTO.setEmail(obj.getEmail());
                    if (obj.getLastLogin() != null) {
                        applicationUserDTO.setLastLogin(obj.getLastLogin());
                    } else {
                        applicationUserDTO.setLastLogin("Not Login Yet");
                    }
                    applicationUserDTO.setUsername(obj.getUsername());
                    applicationUserDTO.setStatusDetails(obj.getStatus().equals('A') ? "Active" : "Deactive");
                    excelPojoList.add(applicationUserDTO);
                }
                String columnHeaders[] = {"Full Name", "Mobile Number", "Email Address", "Last Login", "Username", "Status"};
                System.out.println("\nRequesting to generate report==========>>>>>>>>>>");
                WriteExcelForApplicationUser writeExcel = new WriteExcelForApplicationUser();

                File file = writeExcel.write(columnHeaders, excelPojoList);

                FileInputStream fileIn = null;
                try {
                    response.setContentType("application/octet-stream");
                    response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
                    fileIn = new FileInputStream(file);
                    ServletOutputStream out = response.getOutputStream();
                    byte[] outputByte = new byte[(int) file.length()];
                    //copy binary content to output stream
                    while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
                        out.write(outputByte, 0, (int) file.length());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fileIn != null) {
                        try {
                            fileIn.close();
                            if (file != null) {
                                file.delete();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (WriteException ex) {
            Logger.getLogger(UserRecordDumpServlet.class.getName()).log(Level.SEVERE, null, ex);
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
