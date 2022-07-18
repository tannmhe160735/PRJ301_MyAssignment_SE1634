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
public class Attendance {
    private int attendanceId;
    private Student student;
    private Date date;
    private String group;
    private boolean taken;
    private String subject;
    private int slot;

    public Attendance() {
    }

    public Attendance(int attendanceId, Student student, Date date, String group, boolean taken, String subject, int slot) {
        this.attendanceId = attendanceId;
        this.student = student;
        this.date = date;
        this.group = group;
        this.taken = taken;
        this.subject = subject;
        this.slot = slot;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
    
    
}
