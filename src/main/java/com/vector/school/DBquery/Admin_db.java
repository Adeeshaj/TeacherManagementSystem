package com.vector.school.DBquery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.vector.school.model.Admin;
import com.vector.school.model.User;

import java.net.UnknownHostException;
import java.util.Date;

public class Admin_db {
    private String _id;
    private String user_id;
    private String name;
    private String admin_prof_pic;
    private Date birthday;

    public Admin_db(String _id, String user_id, String name, String admin_prof_pic, Date birthday) {
        this._id = _id;
        this.user_id = user_id;
        this.name = name;
        this.admin_prof_pic = admin_prof_pic;
        this.birthday = birthday;
    }

    public Admin_db() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmin_prof_pic() {
        return admin_prof_pic;
    }

    public void setAdmin_prof_pic(String admin_prof_pic) {
        this.admin_prof_pic = admin_prof_pic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean post_admin(Admin admin){
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(this);
        System.out.println(json);
        DBObject admin_doc = (DBObject) JSON.parse(json);

        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("admins");
            collection.insert(admin_doc);
            mongoClient.close();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

    }
    public Admin get_admin(User user){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("admins");
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("user_id",user.get_id());
            DBObject object = collection.findOne(whereQuery);
            mongoClient.close();

            if (object != null){
                Admin_db admin_db_ob = new Gson().fromJson(object.toString(), Admin_db.class);
                return new Admin(admin_db_ob.getUser_id(),admin_db_ob.getName(),admin_db_ob.getAdmin_prof_pic(),admin_db_ob.getBirthday());


            }
            else{
                return null;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update_admin(Admin admin){
        Admin_db temp_admin = get_admin_fromId(admin.get_id());
        this.set_id(temp_admin.get_id());
        this.setAdmin_prof_pic(temp_admin.getAdmin_prof_pic());
        this.setBirthday(temp_admin.getBirthday());
        this.setName(temp_admin.getName());
        this.setUser_id(temp_admin.getUser_id());
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(this);
        DBObject admin_doc = (DBObject) JSON.parse(json);

        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("teachers");

            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("_id", temp_admin.get_id());

            collection.update(updateObject,admin_doc);
            mongoClient.close();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Admin_db get_admin_fromId(String user_id){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("admins");
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("user_id",user_id);
            DBObject object = collection.findOne(whereQuery);
            mongoClient.close();

            if (object != null){
                return new Gson().fromJson(object.toString(), Admin_db.class);


            }
            else{
                return null;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
