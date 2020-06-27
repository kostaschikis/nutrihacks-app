package com.example.nutrihacks_app.ui.contact;

public class User {

    public String firstName;
    public String lastName;
    public String email;
    public String age;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String firstName, String lastName, String email, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

}