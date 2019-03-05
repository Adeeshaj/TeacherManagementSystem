package com.vector.school.Controller;

import com.vector.school.DBquery.Teacher_db;
import com.vector.school.model.Teacher;

import java.util.List;

public class Home_controller {
    public List<Teacher> get_all_teachers(){
        Teacher_db teacher_db = new Teacher_db();
        return teacher_db.get_all_teachers();
    }
}
