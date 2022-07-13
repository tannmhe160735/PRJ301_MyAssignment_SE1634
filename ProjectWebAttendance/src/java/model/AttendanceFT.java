/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author minht
 */
public class AttendanceFT {
    private int AFTId;
    private Date date;
    private String group;
    private boolean taken;
    private String subject;
    private int slot;
    private Teacher teacher;

    public AttendanceFT() {
    }

    public AttendanceFT(int AFTId, Date date, String group, boolean taken, String subject, int slot, Teacher teacher) {
        this.AFTId = AFTId;
        this.date = date;
        this.group = group;
        this.taken = taken;
        this.subject = subject;
        this.slot = slot;
        this.teacher = teacher;
    }

    public int getAFTId() {
        return AFTId;
    }

    public void setAFTId(int AFTId) {
        this.AFTId = AFTId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

   
    
    
}
