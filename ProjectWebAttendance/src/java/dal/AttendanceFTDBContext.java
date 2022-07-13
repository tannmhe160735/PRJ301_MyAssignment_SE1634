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
import model.AttendanceFT;
import model.Group;
import model.Subject;


/**
 *
 * @author minht
 */
public class AttendanceFTDBContext extends DBContext<AttendanceFT> {

    public ArrayList<AttendanceFT> listDatebyteacherId(String teacherId) {
        ArrayList<AttendanceFT> attendanceFT = new ArrayList<>();
        try {
            String sql = " select distinct date From AttendanceFT where  teacher = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, teacherId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AttendanceFT a = new AttendanceFT();
                a.setDate(rs.getDate("date"));
                attendanceFT.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceFTDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendanceFT;
    }
    
    public ArrayList<AttendanceFT> listSlotbyteacherId(String teacherId) {
        ArrayList<AttendanceFT> attendanceFT = new ArrayList<>();
        try {
            String sql = " select distinct slot From AttendanceFT where  teacher = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, teacherId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AttendanceFT a = new AttendanceFT();
                a.setSlot(rs.getInt("slot"));
                attendanceFT.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceFTDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendanceFT;
    }
        
    public ArrayList<AttendanceFT> listbyteacherId(String teacherId) {
        ArrayList<AttendanceFT> attendanceFT = new ArrayList<>();
        try {
            String sql = "SELECT *\n"
                    + "FROM [AttendanceFT] \n"
                    + "where teacher = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, teacherId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AttendanceFT a = new AttendanceFT();
                a.setAFTId(rs.getInt("AFTId"));
                a.setDate(rs.getDate("date"));
                Group g = new Group();
                a.setGroup(rs.getString("class"));
                a.setTaken(rs.getBoolean("taken"));
                Subject s = new Subject();
                a.setSubject(rs.getString("subject"));
                a.setSlot(rs.getInt("slot"));
                attendanceFT.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceFTDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendanceFT;
    }

    @Override
    public ArrayList<AttendanceFT> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AttendanceFT get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(AttendanceFT model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AttendanceFT model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AttendanceFT model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
