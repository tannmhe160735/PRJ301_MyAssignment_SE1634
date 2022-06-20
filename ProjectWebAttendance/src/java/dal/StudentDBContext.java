/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import model.Teacher;
import model.Class;

/**
 *
 * @author minht
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Class> listBySname(String sname) {
        ArrayList<Class> classes = new ArrayList<>();
        try {
            String sql = "select * from Class c, Teacher t, Student s\n"
                    + "where c.Teacher = t.tid and c.cid = s.class and s.sname = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sname);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setTid(rs.getString("tid"));
                t.setTname(rs.getString("tname"));
                Class c = new model.Class();
                c.setCid(rs.getString("cid"));
                c.setCname(rs.getString("cname"));
                c.setTeacher(t);
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSimage(rs.getString("simage"));
                s.setSname(rs.getString("sname"));
                s.setClasses(c);
                s.setAttendence(rs.getBoolean("attendance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }

    public ArrayList<Student> listByCLass(String cid) {
        ArrayList<Student> stus = new ArrayList<>();
        try {
            String sql = "select s.sid, s.simage, s.sname, s.class, s.attendance \n"
                    + "from Student s, Class c\n"
                    + "where s.class = c.cid and c.cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSimage(rs.getString("simage"));
                s.setSname(rs.getString("sname"));
                stus.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stus;
    }
    
    public void AttendanceBySid(boolean attendance, String sid){
        try {
            String sql = "UPDATE [Student]\n" +
                         "   SET [attendance] = ?\n" +
                         " WHERE sid = ?;";
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
