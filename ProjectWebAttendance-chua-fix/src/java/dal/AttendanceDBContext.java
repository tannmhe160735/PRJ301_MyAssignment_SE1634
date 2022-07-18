/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.AttendanceFT;
import model.Group;
import model.Student;
import model.Subject;

/**
 *
 * @author minht
 */
public class AttendanceDBContext extends DBContext<Attendance> {

    public ArrayList<Attendance> listByClassDate(String group, Date date, int slot) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select A.class, A.taken, S.classId, S.image, S.studentId, S.studentName\n"
                    + "from Attendance A , Student S\n"
                    + "where A.student = S.studentId and S.classId = ? and date = ? and A.slot = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, group);
            stm.setDate(2, date);
            stm.setInt(3, slot);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setTaken(rs.getBoolean("taken"));
                a.setGroup(rs.getString("class"));
                Student s = new Student();
                s.setClassId(rs.getString("classId"));
                s.setImage(rs.getString("image"));
                s.setStudentId(rs.getString("studentId"));
                s.setStudentName(rs.getString("studentName"));
                a.setStudent(s);
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendances;
    }

    public void AttendanceBySid(boolean taken, String studentId, Date date) {
        try {
            String sql = "UPDATE [Attendance]\n"
                    + "SET [taken] = ?\n"
                    + "WHERE student = ? and date = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, taken);
            stm.setString(2, studentId);
            stm.setDate(3, date);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Attendance> listSubjectByStudent(String studentId) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "SELECT distinct subject FROM Attendance \n" +
                         "WHERE student = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, studentId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setSubject(rs.getString("subject"));
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendances;
    }
    
    public ArrayList<Attendance> listBySubjectStudent(String studentId, String subject) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select student, date, class, taken, subject, slot from Attendance\n" +
                         "where subject = ? and student = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(2, studentId);
            stm.setString(1, subject);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setDate(rs.getDate("date"));
                a.setGroup(rs.getString("class"));
                a.setTaken(rs.getBoolean("taken"));
                a.setSlot(rs.getInt("slot"));
                attendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendances;
    }
    
    public ArrayList<Attendance> listDatebyteacherId(String studentId) {
        ArrayList<Attendance> attendance = new ArrayList<>();
        try {
            String sql = " select distinct date From Attendance where  student = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, studentId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setDate(rs.getDate("date"));
                attendance.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendance;
    }
    
    public ArrayList<Attendance> listSlotbyteacherId(String studentId) {
        ArrayList<Attendance> attendance = new ArrayList<>();
        try {
            String sql = " select distinct slot From Attendance where  student = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, studentId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setSlot(rs.getInt("slot"));
                attendance.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendance;
    }
    
    public ArrayList<Attendance> listbyteacherId(String studentId) {
        ArrayList<Attendance> attendance = new ArrayList<>();
        try {
            String sql = "SELECT *\n"
                    + "FROM [Attendance]\n"
                    + "where student = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, studentId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setAttendanceId(rs.getInt("attendanceId"));
                a.setDate(rs.getDate("date"));
                a.setGroup(rs.getString("class"));
                a.setTaken(rs.getBoolean("taken"));
                a.setSubject(rs.getString("subject"));
                a.setSlot(rs.getInt("slot"));
                attendance.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendance;
    }
    
    @Override
    public ArrayList<Attendance> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendance get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
