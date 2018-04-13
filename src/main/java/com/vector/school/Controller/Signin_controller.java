package com.vector.school.Controller;

import com.vector.school.DBquery.Admin_db;
import com.vector.school.DBquery.Teacher_db;
import com.vector.school.DBquery.User_db;
import com.vector.school.Utils.PasswordUtils;
import com.vector.school.model.Admin;
import com.vector.school.model.Teacher;
import com.vector.school.model.User;

public class Signin_controller {
    public User signin_user(String username,String password) {
        boolean user_auth;
        User user = new User_db().get_user(username);
        System.out.println(user.get_id());
        if(user != null){
            user_auth= PasswordUtils.verifyUserPassword(password, user.getPassword(), user.getSalt());
        }
        else{
            user_auth = false;
        }

        if (user_auth){
            return user;
        }else {
            return null;
        }

    }
}
