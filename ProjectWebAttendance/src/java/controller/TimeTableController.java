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
import java.util.ArrayList;
import model.Attendance;
import model.AttendanceFT;

/**
 *
 * @author minht
 */
public class TimeTableController extends HttpServlet {
   
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
            out.println("<title>Servlet TimeTableController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeTableController at " + request.getContextPath () + "</h1>");
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
        Boolean isAdmin = Boolean.valueOf(request.getParameter("isAdmin"));
        request.setAttribute("isAdmin", isAdmin);
        if(isAdmin == true){
            String teacherId = request.getParameter("teacherId");
            AttendanceFTDBContext aft = new AttendanceFTDBContext();
            ArrayList<AttendanceFT> attenFTs = aft.listbyteacherId(teacherId);
            ArrayList<AttendanceFT> date = aft.listDatebyteacherId(teacherId);
            ArrayList<AttendanceFT> slot = aft.listSlotbyteacherId(teacherId);
            request.setAttribute("slot", slot);
            request.setAttribute("date", date);
            request.setAttribute("attenFTs", attenFTs);
            request.getRequestDispatcher("html/timetable.jsp").forward(request, response);
        }else{
            String studentId = request.getParameter("studentId");
            AttendanceDBContext aft = new AttendanceDBContext();
            ArrayList<Attendance> attens = aft.listbyteacherId(studentId);
            ArrayList<Attendance> date = aft.listDatebyteacherId(studentId);
            ArrayList<Attendance> slot = aft.listSlotbyteacherId(studentId);
            request.setAttribute("slot", slot);
            request.setAttribute("date", date);
            request.setAttribute("attenFTs", attens);
            request.getRequestDispatcher("html/timetable.jsp").forward(request, response);
        }
        
        

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
        Boolean isAdmin = Boolean.valueOf(request.getParameter("isAdmin"));
        request.setAttribute("isAdmin", isAdmin);
        String teacherId = request.getParameter("teacherId");
        AttendanceFTDBContext aft = new AttendanceFTDBContext();
        ArrayList<AttendanceFT> attenFTs = aft.listbyteacherId(teacherId);
        ArrayList<AttendanceFT> date = aft.listDatebyteacherId(teacherId);
        ArrayList<AttendanceFT> slot = aft.listSlotbyteacherId(teacherId);
        request.setAttribute("slot", slot);
        request.setAttribute("date", date);
        request.setAttribute("attenFTs", attenFTs);
        request.getRequestDispatcher("html/timetable.jsp").forward(request, response);
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
