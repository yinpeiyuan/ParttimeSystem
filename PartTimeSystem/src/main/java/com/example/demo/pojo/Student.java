package com.example.demo.pojo;

import java.util.List;

public class Student {
    private  String account ;
    private  String stu_nu;
    private  String name;
    private String instructor_id;
    private String major;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private List<Parttime> parttimelist ;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStu_nu() {
        return stu_nu;
    }

    public void setStu_nu(String stu_nu) {
        this.stu_nu = stu_nu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<Parttime> getParttimelist() {
        return parttimelist;
    }

    public void setParttimelist(List<Parttime> parttimelist) {
        this.parttimelist = parttimelist;
    }

    @Override
    public String toString() {
        return "Student{" +
                "account='" + account + '\'' +
                ", stu_nu='" + stu_nu + '\'' +
                ", name='" + name + '\'' +
                ", instructor_id='" + instructor_id + '\'' +
                ", major='" + major + '\'' +
                ", parttimelist=" + parttimelist +
                '}';
    }
}
