package com.example.instagram;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private Database(){}

    public static void makeConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://62.3.41.49/h210327_instagram" , "h210327_software" , "Ea2TgRX9");
            statement = connection.createStatement();
            System.out.println(connection.getNetworkTimeout());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeConnection(){
        if(connection != null){
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createUser(User user) {
        makeConnection();
        try {
            if(checkUsername(user.getUsername())) {
                statement.execute(String.format("insert into users (username , password ,Access , Name) Values "
                        +" ('%s','%s','%s','%s')", user.getUsername() , user.getPassword() , user.getAccess() , user.getName()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void deleteUser(User user) {
        makeConnection();
        try {
            statement.execute(String.format("delete from users where username = '%s'" , user.getUsername()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }



    public static boolean checkUsername(String username){
        makeConnection();
        try {
            ResultSet temp = statement.executeQuery(String.format("SELECT COUNT(username) from users where username = '%s'" , username));
            temp.next();
            if(temp.getInt(1) == 0){
                closeConnection();
                return true;
            }else {
                closeConnection();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return false;
    }



    public static boolean checkAccount(String username , String password){
        makeConnection();
        try {
            ResultSet temp = statement.executeQuery(String.format("SELECT * from users where username = '%s'" , username));
            temp.next();
            String tempUser = temp.getString("username");
            String tempPass = temp.getString("password");
            if(tempPass.equals(password) && tempUser.equalsIgnoreCase(username)){
                closeConnection();
                return true;
            }
            else{
                closeConnection();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return false;
    }
    public static void AddUser(String username, String password, String name){
        makeConnection();
        try {
            statement.execute(String.format("insert into users (username, password,Access, Name) Values "
                    +" ('%s','%s','%s','%s')", username, password, "Client", name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static boolean setInfo(String username, String password){
        makeConnection();
        try {
            ResultSet temp = statement.executeQuery(String.format("SELECT * from users where username = '%s'" , username));
            temp.next();
            String tempUser = temp.getString("username");
            String tempPass = temp.getString("password");
            String tempName =  temp.getString("Name");
            String tempAccess = temp.getString("Access");
            if(tempPass.equals(password) && tempUser.equalsIgnoreCase(username)){
                User.setPassword(tempPass);
                User.setUsername(tempUser);
                User.setName(tempName);
                User.setAccess(tempAccess);
                closeConnection();
                return true;
            }
            else{
                closeConnection();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return false;
    }

    public static ArrayList<Message> getMessage(){
        ArrayList<Message> messages = new ArrayList<>();
        makeConnection();
        try {
            ResultSet temp = statement.executeQuery("SELECT * FROM messages");
            int number = getNumberColumn("messages");
            if(number > 100){
                number = 100;
            }
            for(int i = 0; i < number ; i++){
                temp.next();
                Message message = new Message(temp.getString("Message") ,temp.getString("Date"),temp.getString("like_number"),temp.getString("Sender"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return messages;
    }

    public static int getNumberColumn(String tableName){
        makeConnection();
        try {
            ResultSet temp = statement.executeQuery("SELECT COUNT(*) FROM " + tableName);
            temp.next();
            closeConnection();
            return temp.getInt(1);
        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }
        closeConnection();
        return 0;
    }

    public static void addMessage(Message message){
        makeConnection();
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            statement.execute(String.format("insert into messages (Message,Sender,like_number,Date) Values "
                    +" ('%s','%s','%s','%s')",message.getMessage() , message.getUsername() , "0" , dateTime.toString()));
            closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        closeConnection();
    }

    public static String getPing(){
        String ping ;
        makeConnection();
        try {
            if(connection.isValid(5000)){
                long endTime = System.currentTimeMillis();
                long pingTime = endTime - 5000;
                ping = Long.toString(pingTime);
            }
            else{
                ping = "999";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
        return ping;
    }

}
