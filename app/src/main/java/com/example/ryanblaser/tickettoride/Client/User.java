package com.example.ryanblaser.tickettoride.Client;


/**
 * Created by RyanBlaser on 2/5/17.
 */

public class User {

    //Data members
	String username;
	String password;
    private String str_authentication_code;

    //Constructor
    public User() {
    	username = "";
    	password = "";
        str_authentication_code = "-1" ; //initialize to -1 for debugging purposes.
    }
<<<<<<< HEAD
=======

    public User(String u, String p)
    {
        username = u;
        password = p;
    }
>>>>>>> 960a86b1539ed8a6872c5df4b399c4b605bfe5a8
    
    @Override
    public String toString() {
    	return "Username: " + getUsername() + "\npassword: " + getPassword() + "\nauthentication: " + getStr_authentication_code() + "\n";
    }

    //Getters
    /*
     * Goes into the Username class and changes the string there
     */
    public String getUsername() {
    	return username;
//        return username.getUsername();
    }

    /*
     * Goes into the Username class and changes the string there
     */
    public void setUsername(String username) {
    	this.username = username;
//        this.username.setUsername(username);
    }

    public String getStr_authentication_code() {
        return str_authentication_code;
    }

    //Setters
    /*
     * Goes into the Password class and grabs the string version of the password.
     */
    public String getPassword() {
    	return password;
//        return password.getPassword();
    }

    /*
     * Goes into the Password class and changes the string there
     */
    public void setPassword(String password) {
    	this.password = password;
//        this.password.setPassword(password);
    }

    public void setStr_authentication_code(String str_authentication_code) {
        this.str_authentication_code = str_authentication_code;
    }
}
