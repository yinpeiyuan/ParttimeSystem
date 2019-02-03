package com.example.demo.mapper;

import com.example.demo.pojo.Introducer;
import com.example.demo.pojo.Parttime;
import com.example.demo.pojo.ParttimeStudent;
import com.example.demo.pojo.Student;
import com.example.demo.utils.MyMapper;

import java.util.List;

public interface InstructorDao extends MyMapper<Parttime> {
    public List<ParttimeStudent> parttimeList2(String stu_nu);

    public  void deleteParttime(Parttime parttime);

    public  List<Introducer> selectIntroducer();

    public  void  deleteStudent(String stu_nu);


    public  void  changeIntroducerStatus(Introducer introducer);

    public  List<Student> selectStudent(String account);

    public  List<Parttime> selectParttime(String stu_nu);

    public void addStudent(Student student);

    public  void editStudent(Student student);
}

