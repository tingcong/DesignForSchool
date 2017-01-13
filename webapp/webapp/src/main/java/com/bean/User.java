package com.bean;

/**
 * Created by 胡廷聪 on 2016/12/14.
 */
public class User {
    private Integer id;
    //工号（学号和老师工号）
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String password;
    private Boolean isAdmin;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Integer id, int no, String password, Boolean isAdmin) {
        this.id = id;
        this.no = no;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User() {
    }
}
