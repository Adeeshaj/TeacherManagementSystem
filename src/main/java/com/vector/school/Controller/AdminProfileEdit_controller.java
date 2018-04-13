package com.vector.school.Controller;

import com.vector.school.App;
import com.vector.school.DBquery.Admin_db;
import com.vector.school.model.Admin;
import com.vector.school.model.User;

import java.util.Date;

public class AdminProfileEdit_controller {
    public boolean updateTeacher(String name, String profPic, Date birthday){
        boolean retval = false;
        User cache_user = App.cacheUser;
        Admin updated_admin = new Admin(cache_user.get_id(),cache_user.getUser_name(),cache_user.getPassword(),cache_user.getSalt(),null,cache_user.getUserrole(),name,profPic,birthday);
        Admin_db admin_db = new Admin_db();
        if(admin_db.update_admin(updated_admin)){
            retval = true;
        }
        return retval;
    }

    public Admin getTeacher(User user){
        Admin admin = new Admin_db().get_admin(user);
        System.out.println(admin.get_id());
        return admin;
    }
}
