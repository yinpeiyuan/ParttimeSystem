package com.example.demo.pojo;

import java.util.Date;

public class Parttime {
    private String Id;
    private String parttime_name;
    private  String name;
    private String introducer_id;
    private String location;
    private  int nu_of_people;
    private  String  phone ;
    private String salary  ;
    private String status  ;
    private Date start_time ;
    private Date end_time ;
    private String status_stu;

    public String getStatus_stu() {
        return status_stu;
    }

    public void setStatus_stu(String status_stu) {
        this.status_stu = status_stu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParttime_name() {
        return parttime_name;
    }

    public void setParttime_name(String parttime_name) {
        this.parttime_name = parttime_name;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIntroducer_id() {
        return introducer_id;
    }

    public void setIntroducer_id(String introducer_id) {
        this.introducer_id = introducer_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNu_of_people() {
        return nu_of_people;
    }

    public void setNu_of_people(int nu_of_people) {
        this.nu_of_people = nu_of_people;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Parttime{" +
                "Id='" + Id + '\'' +
                ", introducer_id='" + introducer_id + '\'' +
                ", location='" + location + '\'' +
                ", nu_of_people=" + nu_of_people +
                ", phone='" + phone + '\'' +
                ", salary='" + salary + '\'' +
                ", status='" + status + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", parttime_name='" + parttime_name + '\'' +
                '}';
    }
}
