package com.example.instagram;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Message {
    private VBox vBox = new VBox();
    private String message;
    private String like_Number;
    private String Date;
    private String username;
    private Text from = new Text(username);
    private TextArea messageArea = new TextArea();
    private HBox hBox = new HBox();
    private Button like = new Button("Like");
    private Text date = new Text(Date);
    private Text likeNumber = new Text(like_Number);
    public Message(String message, String like_Number, String date, String username) {
        this.message = message;
        this.like_Number = like_Number;
        Date = date;
        this.username = username;
        vBox.setAlignment(Pos.TOP_RIGHT);
        vBox.setSpacing(10);
        vBox.setPrefHeight(300);
        vBox.setPrefWidth(570);
        messageArea.setText(String.valueOf(message));
        messageArea.setEditable(false);
        from.setText(username);
        this.date.setText(date);
        likeNumber.setText(like_Number);
        hBox.getChildren().addAll(like, this.date, likeNumber);
        hBox.setSpacing(5);
        vBox.getChildren().addAll(from, messageArea, hBox);
    }

    public VBox getvBox() {
        return vBox;
    }

    public String getMessage() {
        return message;
    }

    public String getLike_Number() {
        return like_Number;
    }

    public String getDate() {
        return Date;
    }

    public Text getFrom() {
        return from;
    }

    public String getUsername() {
        return username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLike_Number(String like_Number) {
        this.like_Number = like_Number;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
