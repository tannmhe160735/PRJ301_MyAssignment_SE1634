/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class Student {
    private String sid;
    private String simage;
    private String sname;
    private Class classes;
    private boolean attendence;

    public Student() {
    }

    public Student(String sid, String simage, String sname, Class classes, boolean attendence) {
        this.sid = sid;
        this.simage = simage;
        this.sname = sname;
        this.classes = classes;
        this.attendence = attendence;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public boolean isAttendence() {
        return attendence;
    }

    public void setAttendence(boolean attendence) {
        this.attendence = attendence;
    }

    
    
}
