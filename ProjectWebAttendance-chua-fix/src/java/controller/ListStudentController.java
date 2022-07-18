/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AttendanceDBContext;
import dal.AttendanceFTDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Attendance;
import model.Student;

/**
 *
 * @author minht
 */
public class ListStudentController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListStudentController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListStudentController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String groupId = request.getParameter("groupId");
        Date date = Date.valueOf(request.getParameter("date"));
        int slot = Integer.parseInt(request.getParameter("slot"));
        request.setAttribute("thatGroup", groupId);
        request.setAttribute("thatDay", date);
        AttendanceDBContext aDB = new AttendanceDBContext();
        ArrayList<Attendance> attends = aDB.listByClassDate(groupId, date, slot);
        request.setAttribute("attends", attends);
        request.getRequestDispatcher("html/liststudent.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AttendanceDBContext aDB = new AttendanceDBContext();
        AttendanceFTDBContext aftDB = new AttendanceFTDBContext();
        Date date = Date.valueOf(request.getParameter("date"));
        String[] indexs = request.getParameterValues("index");
        for (String index : indexs) {
            String studentId = request.getParameter("studentId"+index);
            boolean taken = Boolean.parseBoolean(request.getParameter("taken"+index));
            aDB.AttendanceBySid(taken, studentId, date);
        }
        String groupId = request.getParameter("groupId");
        aftDB.AttendanceFTByClass(groupId, date);
        request.getRequestDispatcher("html/home.jsp").forward(request, response);
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}