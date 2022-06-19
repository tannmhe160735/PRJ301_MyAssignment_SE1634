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

/**
 *
 * @author minht
 */
public class StudentDBContext extends DBContext<Student>{

    public ArrayList<model.Class> listBySname(String sname) {
        ArrayList<model.Class> classes = new ArrayList<>();
        try {
            String sql = "select * from Class c, Teacher t, Student s\n" +
                         "where c.Teacher = t.tid and c.cid = s.class and s.sname = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sname);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Teacher t = new Teacher();
                t.setTid(rs.getString("tid"));
                t.setTname(rs.getString("tname"));
                model.Class c = new model.Class();
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
