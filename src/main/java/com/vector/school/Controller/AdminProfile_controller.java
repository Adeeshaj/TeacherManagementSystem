package com.vector.school.Controller;

import com.vector.school.DBquery.Admin_db;
import com.vector.school.model.Admin;
import com.vector.school.model.User;

public class AdminProfile_controller {
    public Admin getTeacher(User user){
        Admin admin = new Admin_db().get_admin(user);
        System.out.println(admin.get_id());
        return admin;
    }
}
