package com.vector.school.model;

public class User {
    private String _id;
    private String user_name;
    private String password;
    private String salt;
    private String[] notification;
    private String userrole;

    public User(String _id, String user_name, String password, String salt, String[] notification, String userrole) {
        this._id = _id;
        this.user_name = user_name;
        this.password = password;
        this.salt = salt;
        this.notification = notification;
        this.userrole = userrole;
    }



    protected User(String _id) {
        this._id = _id;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getNotification() {
        return notification;
    }

    public void setNotification(String[] notification) {
        this.notification = notification;
    }

    public String getSalt() {
        return salt;
    }

}
