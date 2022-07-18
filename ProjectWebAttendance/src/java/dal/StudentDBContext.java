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
import model.Student;

/**
 *
 * @author minht
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Student> listByCLass(String classId) {
        ArrayList<Student> stus = new ArrayList<>();
        try {
            String sql = "select studentId, image, classId, studentName from Student S where S.classId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, classId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getString("studentId"));
                s.setImage(rs.getString("image"));
                s.setClassId(rs.getString("classId"));
                s.setStudentName(rs.getString("studentName"));
                stus.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stus;
    }  

    public void AttendanceBySid(boolean attendance, String sid) {
        try {
            String sql = "UPDATE [Student]\n"
                    + "   SET [attendance] = ?\n"
                    + " WHERE sid = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, attendance);
            stm.setString(2, sid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Student> list() {
        return null;
    }

    @Override
    public Student get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {

    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
