package com.example.instagram;

public class User {
    private static String username , password , access , name;

    public User(String username, String password, String access, String name) {
        User.username = username;
        User.password = password;
        User.access = access;
        User.name = name;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getAccess() {
        return access;
    }

    public static void setAccess(String access) {
        User.access = access;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }
}
