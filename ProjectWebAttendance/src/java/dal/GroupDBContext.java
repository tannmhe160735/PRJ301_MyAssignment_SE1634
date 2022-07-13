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
import model.Group;


/**
 *
 * @author minht
 */
public class GroupDBContext extends DBContext<Group>{

    public ArrayList<Group> listByTeacheridDate(String teacherId, Date date) {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select distinct G.groupId from [Group] G, AttendanceFT A where G.groupId = A.class and A.teacher = ? and A.date = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, teacherId);
            stm.setDate(2, date);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Group g = new Group();
                g.setGroupId(rs.getString("groupId"));
                groups.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }
    
    @Override
    public ArrayList<Group> list() {     
        return null;
    }

    @Override
    public Group get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
