package com.vector.school.Controller;

import com.vector.school.DBquery.Teacher_db;
import com.vector.school.model.Teacher;
import com.vector.school.model.User;

public class TeacherProfile_controller {
    public Teacher getTeacher(User user){
        Teacher teacher = new Teacher_db().get_teacher(user);
        System.out.println(teacher.get_id());
        return teacher;
    }
}
