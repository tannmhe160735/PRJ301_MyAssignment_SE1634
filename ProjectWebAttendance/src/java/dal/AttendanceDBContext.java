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
import model.Student;

/**
 *
 * @author minht
 */
public class AttendanceDBContext extends DBContext<Attendance> {

    public ArrayList<Attendance> listByClassDate(String group, Date date) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        try {
            String sql = "select A.class, A.taken, S.classId, S.image, S.studentId, S.studentName \n"
                    + "from Attendance A , Student S \n"
                    + "where A.student = S.studentId and S.classId = ? and date = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, group);
            stm.setDate(2, date);
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
