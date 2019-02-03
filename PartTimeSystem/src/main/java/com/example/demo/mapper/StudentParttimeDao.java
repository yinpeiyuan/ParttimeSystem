package com.example.demo.mapper;

import com.example.demo.pojo.Parttime;
import com.example.demo.pojo.ParttimePerson;
import com.example.demo.pojo.ParttimeStudent;
import com.example.demo.utils.MyMapper;

import java.util.List;

public interface StudentParttimeDao extends MyMapper<Parttime> {
   public List<ParttimeStudent> parttimeList(String stu_id);

   public  void  shenqingjianzhiStatus(ParttimePerson parttimePerson);

   public List<ParttimeStudent>  parttimeDoList(String stu_nu);

   public void changeStupartttimeStatus(ParttimePerson parttimePerson);
}
