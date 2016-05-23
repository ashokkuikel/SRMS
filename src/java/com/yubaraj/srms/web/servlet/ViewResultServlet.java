package com.yubaraj.srms.web.servlet;

import com.yubaraj.srms.web.DTO.ResultsDTO;
import com.yubaraj.srms.web.dbManagers.DatabaseManager;
import com.yubaraj.srms.web.dbManagers.Manager;
import com.yubaraj.srms.web.entities.ApplicationUser;
import com.yubaraj.srms.web.entities.Marks;
import com.yubaraj.srms.web.entities.Student;
import com.yubaraj.srms.web.utilities.ActionUtils;
import com.yubaraj.srms.web.utilities.SRMSConstant;
import java.io.IOException;
import java.text.DecimalFormat;
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
@WebServlet(name = "ViewResultServlet", urlPatterns = {"/viewResultServlet"})
public class ViewResultServlet extends HttpServlet {

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

        String rollString = request.getParameter("rollNo");

        List<ResultsDTO> resultList = new ArrayList<>();

        if (rollString != null) {

            Long rollNo = new Long(rollString);

            Student student = manager.getStudent(rollNo);
            String studentName = student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName();
            String course = student.getCourseName();

            Double totalObtainedMarks = manager.getSumOfObtainedMarksByStudentId(rollNo);
            Double totalFullMarks = manager.getSumOfTotalFullMarksByStudentId(rollNo);

            List<Marks> marksList = manager.getMarks(rollNo);

            for (Marks marks : marksList) {
                ResultsDTO resultDto = new ResultsDTO();
                resultDto.setFullMarks(marks.getFullMarks());
                resultDto.setMarksValue(marks.getMarksValue());
                resultDto.setPassMarks(marks.getPassMarks());
                resultDto.setSubjectName(marks.getSubject());
                if (marks.getMarksValue() >= marks.getPassMarks()) {
                    resultDto.setResult(SRMSConstant.PASSED + "!");
                } else {
                    resultDto.setResult(SRMSConstant.FAILLED + "!");
                }
                resultList.add(resultDto);
            }

            request.setAttribute("studentName", studentName);
            request.setAttribute("rollNo", rollNo);
            request.setAttribute("course", course);
            request.setAttribute("totalMarks", totalObtainedMarks);
            request.setAttribute("percent", calculatePercent(totalFullMarks, totalObtainedMarks));
            if (isPassed(resultList)) {
                request.setAttribute("result", SRMSConstant.PASSED + " !");
            } else {
                request.setAttribute("result", SRMSConstant.FAILLED + " !");
            }
        }
        request.setAttribute("resultList", resultList);
        ActionUtils.sendRequest(request, response, "viewResult.jsp");
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

    private String calculatePercent(Double totalFullMarks, Double totalObtainedMarks) {
        try {
            Double percent = (totalObtainedMarks / totalFullMarks) * 100;
            Double originalValue = Double.parseDouble(new DecimalFormat("##.##").format(percent));
            return String.valueOf(originalValue + " %");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isPassed(List<ResultsDTO> resultList) {
        try {
            List<String> results = new ArrayList<>();
            for (ResultsDTO marks : resultList) {
                results.add(marks.getResult());
            }
            if (results.contains(SRMSConstant.FAILLED)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
