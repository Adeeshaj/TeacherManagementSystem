package com.vector.school.DBquery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.vector.school.model.Teacher;
import com.vector.school.model.User;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teacher_db {
    private String _id;
    private String user_id;
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

    public Teacher_db(String _id, String user_id, String name, String teacher_prof_pic, Date birthday, Date first_apointment_date, Date school_apointment_date, String teacher_appointment_type, String[] subjects, String edu_qualification, String prof_qualification, String nid, String address, String mobile, Boolean availablity) {
        this._id = _id;
        this.user_id = user_id;
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

    public Teacher_db() {
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher_prof_pic(String teacher_prof_pic) {
        this.teacher_prof_pic = teacher_prof_pic;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setFirst_apointment_date(Date first_apointment_date) {
        this.first_apointment_date = first_apointment_date;
    }

    public void setSchool_apointment_date(Date school_apointment_date) {
        this.school_apointment_date = school_apointment_date;
    }

    public void setTeacher_appointment_type(String teacher_appointment_type) {
        this.teacher_appointment_type = teacher_appointment_type;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public void setEdu_qualification(String edu_qualification) {
        this.edu_qualification = edu_qualification;
    }

    public void setProf_qualification(String prof_qualification) {
        this.prof_qualification = prof_qualification;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAvailablity(Boolean availablity) {
        this.availablity = availablity;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher_prof_pic() {
        return teacher_prof_pic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getFirst_apointment_date() {
        return first_apointment_date;
    }

    public Date getSchool_apointment_date() {
        return school_apointment_date;
    }

    public String getTeacher_appointment_type() {
        return teacher_appointment_type;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public String getEdu_qualification() {
        return edu_qualification;
    }

    public String getProf_qualification() {
        return prof_qualification;
    }

    public String getNid() {
        return nid;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public Boolean getAvailablity() {
        return availablity;
    }

    public boolean post_teacher() {

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(this);
        System.out.println(json);


        DBObject teacher_doc = (DBObject) JSON.parse(json);


        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("teachers");
            collection.insert(teacher_doc);
            mongoClient.close();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Teacher get_teacher(User user) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("teachers");
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("user_id", user.get_id());
            DBObject object = collection.findOne(whereQuery);


            System.out.println(object.toString());
            mongoClient.close();

            if (object != null) {
                Teacher_db teacher_db_ob = new Gson().fromJson(object.toString(), Teacher_db.class);
                return new Teacher(teacher_db_ob.getUser_id(),teacher_db_ob.getName(),teacher_db_ob.getTeacher_prof_pic(),teacher_db_ob.getBirthday(),teacher_db_ob.getFirst_apointment_date(),teacher_db_ob.getSchool_apointment_date(),teacher_db_ob.getTeacher_appointment_type(),teacher_db_ob.getSubjects(),teacher_db_ob.getEdu_qualification(),teacher_db_ob.getProf_qualification(),teacher_db_ob.getNid(),teacher_db_ob.getAddress(),teacher_db_ob.getMobile(),teacher_db_ob.getAvailablity());

            } else {
                return null;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update_teacher(Teacher teacher) {
        Teacher_db temp_teacher = get_teacher_fromId(teacher.get_id());
        this.set_id(temp_teacher.get_id());
        this.setAddress(temp_teacher.getAddress());
        this.setAvailablity(temp_teacher.getAvailablity());
        this.setBirthday(temp_teacher.getBirthday());
        this.setEdu_qualification(temp_teacher.getEdu_qualification());
        this.setFirst_apointment_date(temp_teacher.getFirst_apointment_date());
        this.setMobile(temp_teacher.getMobile());
        this.setName(temp_teacher.getName());
        this.setNid(temp_teacher.getNid());
        this.setProf_qualification(temp_teacher.getProf_qualification());
        this.setSchool_apointment_date(temp_teacher.getSchool_apointment_date());
        this.setSubjects(temp_teacher.getSubjects());
        this.setTeacher_appointment_type(temp_teacher.getTeacher_appointment_type());
        this.setTeacher_prof_pic(temp_teacher.getTeacher_prof_pic());
        this.setUser_id(temp_teacher.getUser_id());
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(this);
        DBObject teacher_doc = (DBObject) JSON.parse(json);


        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("teachers");

            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("_id", temp_teacher._id);

            collection.update(updateObject,teacher_doc);
            mongoClient.close();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Teacher_db get_teacher_fromId(String id) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("teachers");
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("user_id", id);
            DBObject object = collection.findOne(whereQuery);

            mongoClient.close();

            if (object != null) {
                Teacher_db teacher_ob = new Gson().fromJson(object.toString(), Teacher_db.class);
                System.out.println(teacher_ob);
                return teacher_ob;
            } else {
                return null;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Teacher> get_all_teachers(){
        List<Teacher> teacher_list = new ArrayList<>();
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("teachers");
            DBCursor cursor  = collection.find();
            while (cursor.hasNext()){
                DBObject object = cursor.next();
                Teacher_db teacher_db_ob = new Gson().fromJson(object.toString(), Teacher_db.class);
                Teacher teacher_obj = new Teacher(teacher_db_ob.getUser_id(),teacher_db_ob.getName(),teacher_db_ob.getTeacher_prof_pic(),teacher_db_ob.getBirthday(),teacher_db_ob.getFirst_apointment_date(),teacher_db_ob.getSchool_apointment_date(),teacher_db_ob.getTeacher_appointment_type(),teacher_db_ob.getSubjects(),teacher_db_ob.getEdu_qualification(),teacher_db_ob.getProf_qualification(),teacher_db_ob.getNid(),teacher_db_ob.getAddress(),teacher_db_ob.getMobile(),teacher_db_ob.getAvailablity());
                teacher_list.add(teacher_obj);

            }

            mongoClient.close();

            return teacher_list;

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}