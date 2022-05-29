/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minht
 */
public class Login {
    private String username;
    private String password;
    private boolean idAdmin;
    private String name;

    public Login() {
    }

    public Login(String username, String password, boolean idAdmin, String name) {
        this.username = username;
        this.password = password;
        this.idAdmin = idAdmin;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(boolean idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
