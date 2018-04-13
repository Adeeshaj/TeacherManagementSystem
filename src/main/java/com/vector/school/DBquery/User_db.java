package com.vector.school.DBquery;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.*;
import com.vector.school.model.User;
import com.vector.school.Utils.*;

import java.io.IOException;
import java.net.UnknownHostException;

public class User_db {

    public boolean post_user(User user){
        DBObject user_doc = new BasicDBObject("_id",user.get_id())
                .append("username",user.getUser_name())
                .append("password",user.getPassword())
                .append("salt",user.getSalt())
                .append("notification",user.getNotification())
                .append("userrole",user.getUserrole());


        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("users");
            collection.insert(user_doc);
            mongoClient.close();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean remove_user(User user){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        DB database = mongoClient.getDB("Schooldb");
        DBCollection collection = database.getCollection("users");
        DBObject query = BasicDBObjectBuilder.start().add("_id", user.get_id()).get();
        collection.remove(query);
        mongoClient.close();
        return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean is_user(String username){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("users");
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("username", username);
            DBObject object = collection.findOne(whereQuery);
            mongoClient.close();
            return object == null;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User get_user(String username){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

            DB database = mongoClient.getDB("Schooldb");
            DBCollection collection = database.getCollection("users");
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("username", username);
            DBObject object = collection.findOne(whereQuery);
            System.out.println(object);
            mongoClient.close();

            if (object != null){

                return new Gson().fromJson(object.toString(), User.class);
            }
            else{
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
