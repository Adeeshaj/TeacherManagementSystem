package com.vector.school.Controller;

import com.vector.school.App;
import com.vector.school.DBquery.Teacher_db;
import com.vector.school.model.Teacher;
import com.vector.school.model.User;

import java.util.Date;

public class TeacherProfileEdit_controller {
    public boolean updateTeacher(String name, String profPic, Date birthday,Date fad,Date sad,String aptType,String[] subjects,String eduQua,String profQua,String nid,String address,String mobile){
        boolean retval = false;
        User cache_user = App.cacheUser;
        Teacher updated_teacher = new Teacher(cache_user.get_id(),cache_user.getUser_name(),cache_user.getPassword(),cache_user.getSalt(),null,name,profPic,birthday,fad,sad,aptType,subjects,eduQua,profQua,nid,address,mobile,null,cache_user.getUserrole());
        Teacher_db teacher_db = new Teacher_db();
        if(teacher_db.update_teacher(updated_teacher)){
            retval = true;
        }
        return retval;
    }

    public Teacher getTeacher(User user){
        System.out.println(user.get_id());
        return new Teacher_db().get_teacher(user);
    }
}
