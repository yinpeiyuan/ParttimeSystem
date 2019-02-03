package com.example.demo.pojo;

import java.util.Date;

public class Introducer {
    private String account;
    private String  name;
    private int  score;
    private int  IDnumber;
    private String   status;
    private String    password;
    private String position;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(int IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Introducer{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", IDnumber=" + IDnumber +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
