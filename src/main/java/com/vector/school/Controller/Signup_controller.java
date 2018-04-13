package com.vector.school.Controller;

import com.vector.school.DBquery.Admin_db;
import com.vector.school.DBquery.Teacher_db;
import com.vector.school.DBquery.User_db;
import com.vector.school.Utils.PasswordUtils;
import com.vector.school.model.Admin;
import com.vector.school.model.Teacher;
import com.vector.school.model.User;

import org.bson.types.ObjectId;

import java.util.Date;

public class Signup_controller {
    public boolean signup_user(String name, String userName, String password, Date birthday,String userrole){
        boolean ret_val;
        ObjectId userid = new ObjectId();

        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt);
        User user = new User(userid.toString(),userName,mySecurePassword,salt,null,userrole);
        if(new User_db().post_user(user)){
            switch (userrole) {
                case "Teacher":
                    Teacher teacher = new Teacher(userid.toString(), userName, mySecurePassword, salt, null, name, birthday, userrole);
                    if (new Teacher_db(new ObjectId().toString(),teacher.get_id(),teacher.getName(),teacher.getTeacher_prof_pic(),teacher.getBirthday(),teacher.getFirst_apointment_date(),teacher.getSchool_apointment_date(),teacher.getTeacher_appointment_type(),teacher.getSubjects(),teacher.getEdu_qualification(),teacher.getProf_qualification(),teacher.getNid(),teacher.getAddress(),teacher.getMobile(),teacher.getAvailablity()).post_teacher()) {
                        ret_val = true;
                    } else {
                        //remove user
                        new User_db().remove_user(user);
                        ret_val = false;
                    }

                    break;
                case "Admin":
                    Admin admin = new Admin(userid.toString(), userName, mySecurePassword, salt, null, name, birthday, userrole);
                    if (new Admin_db().post_admin(admin)) {
                        ret_val = true;
                    } else {
                        //remove user
                        new User_db().remove_user(user);
                        ret_val = false;
                    }
                    break;
                default:
                    ret_val = false;
                    break;
            }
        }else{
            ret_val=false;
        }



        System.out.println("Name: " +name);
        System.out.println("userName: "+userName);
        System.out.println("password: "+password);
        System.out.println(birthday);
        return ret_val;

    }

    public boolean user_name_available(String username){
        boolean retval = new User_db().is_user(username);
        return retval;
    }
}
