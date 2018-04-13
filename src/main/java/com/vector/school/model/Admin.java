package com.vector.school.model;

import java.util.Date;

public class Admin extends User {
    private String name;
    private String admin_prof_pic;
    private Date birthday;

    public Admin(String _id, String user_name, String password, String salt, String[] notification, String userrole, String name, String admin_prof_pic, Date birthday) {
        super(_id, user_name, password, salt, notification, userrole);
        this.name = name;
        this.admin_prof_pic = admin_prof_pic;
        this.birthday = birthday;
    }


    public Admin(String _id, String user_name, String password, String salt, String[] notification, String name, Date birthday, String userrole) {
        super(_id, user_name, password, salt, notification,userrole);
        this.name = name;
        this.birthday = birthday;

    }

    public Admin(String user_id, String name, String admin_prof_pic, Date birthday) {
        super(user_id);
        this.name = name;
        this.admin_prof_pic = admin_prof_pic;
        this.birthday = birthday;

    }


    public String getAdmin_prof_pic() {
        return admin_prof_pic;
    }

    public void setAdmin_prof_pic(String admin_prof_pic) {
        this.admin_prof_pic = admin_prof_pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }
}
