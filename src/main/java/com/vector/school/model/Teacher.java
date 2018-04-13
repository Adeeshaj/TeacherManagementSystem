package com.vector.school.model;

import org.bson.types.ObjectId;

import java.util.Date;

public class Teacher extends User {
    private String name;
    private String teacher_prof_pic;
    private Date birthday;
    private Date first_apointment_date;
    private Date school_apointment_date;
    private String teacher_appointment_type;
    private String[] subjects;
    private String edu_qualification;
    private String prof_qualification;
    private String nid;
    private String address;
    private String mobile;
    private Boolean availablity;


    public Teacher(String user_id, String user_name, String password, String salt, String[] notification, String name, String teacher_prof_pic, Date birthday, Date first_apointment_date, Date school_apointment_date, String teacher_appointment_type, String[] subjects, String edu_qualification, String prof_qualification, String nid, String address, String mobile, Boolean availablity, String userrole) {
        super(user_id, user_name, password, salt, notification, userrole);
        this.name = name;
        this.teacher_prof_pic = teacher_prof_pic;
        this.birthday = birthday;
        this.first_apointment_date = first_apointment_date;
        this.school_apointment_date = school_apointment_date;
        this.teacher_appointment_type = teacher_appointment_type;
        this.subjects = subjects;
        this.edu_qualification = edu_qualification;
        this.prof_qualification = prof_qualification;
        this.nid = nid;
        this.address = address;
        this.mobile = mobile;
        this.availablity = availablity;
    }



    public Teacher(String user_id, String user_name, String password, String salt, String[] notification, String name, Date birthday, String userrole) {
        super(user_id, user_name, password, salt, notification,userrole);
        this.name = name;
        this.birthday = birthday;
    }

    public Teacher(String _id, String name, String teacher_prof_pic, Date birthday, Date first_apointment_date, Date school_apointment_date, String teacher_appointment_type, String[] subjects, String edu_qualification, String prof_qualification, String nid, String address, String mobile, Boolean availablity) {
        super(_id);
        this.name = name;
        this.teacher_prof_pic = teacher_prof_pic;
        this.birthday = birthday;
        this.first_apointment_date = first_apointment_date;
        this.school_apointment_date = school_apointment_date;
        this.teacher_appointment_type = teacher_appointment_type;
        this.subjects = subjects;
        this.edu_qualification = edu_qualification;
        this.prof_qualification = prof_qualification;
        this.nid = nid;
        this.address = address;
        this.mobile = mobile;
        this.availablity = availablity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_prof_pic() {
        return teacher_prof_pic;
    }

    public void setTeacher_prof_pic(String teacher_prof_pic) {
        this.teacher_prof_pic = teacher_prof_pic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getFirst_apointment_date() {
        return first_apointment_date;
    }

    public void setFirst_apointment_date(Date first_apointment_date) {
        this.first_apointment_date = first_apointment_date;
    }

    public Date getSchool_apointment_date() {
        return school_apointment_date;
    }

    public void setSchool_apointment_date(Date school_apointment_date) {
        this.school_apointment_date = school_apointment_date;
    }

    public String getTeacher_appointment_type() {
        return teacher_appointment_type;
    }

    public void setTeacher_appointment_type(String teacher_appointment_type) {
        this.teacher_appointment_type = teacher_appointment_type;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public String getEdu_qualification() {
        return edu_qualification;
    }

    public void setEdu_qualification(String edu_qualification) {
        this.edu_qualification = edu_qualification;
    }

    public String getProf_qualification() {
        return prof_qualification;
    }

    public void setProf_qualification(String prof_qualification) {
        this.prof_qualification = prof_qualification;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getAvailablity() {
        return availablity;
    }

    public void setAvailablity(Boolean availablity) {
        this.availablity = availablity;
    }
}
