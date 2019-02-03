package com.example.demo.pojo;

public class ParttimePerson {
    private String  name;
    private String status;
    private String stu_id;
    private int parttime_id;

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public int getParttime_id() {
        return parttime_id;
    }

    public void setParttime_id(int parttime_id) {
        this.parttime_id = parttime_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ParttimePerson{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", parttime_id=" + parttime_id +
                '}';
    }
}
