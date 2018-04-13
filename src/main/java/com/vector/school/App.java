package com.vector.school;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import com.mongodb.*;
import com.vector.school.UI.Home;
import com.vector.school.UI.User_sign_in;
import com.vector.school.UI.User_sign_up;
import com.vector.school.model.Admin;
import com.vector.school.model.User;

import javax.swing.*;

/**
 * main class
 *
 */
public class App 
{
    public static JFrame frame;
    public static User cacheUser;
    public static void main( String[] args ) throws UnknownHostException {

//        MongoCredential credential = MongoCredential.createMongoCRCredential("root","Examples","1234".toCharArray());
//        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost",27017), Arrays.asList(credential));
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));




        frame = new JFrame("App");
        frame.setContentPane(new Home().getHomeJpanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
