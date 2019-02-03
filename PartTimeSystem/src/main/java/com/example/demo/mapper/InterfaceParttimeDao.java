package com.example.demo.mapper;

import com.example.demo.pojo.Introducer;
import com.example.demo.pojo.Parttime;
import com.example.demo.pojo.ParttimePerson;
import com.example.demo.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


public interface InterfaceParttimeDao extends MyMapper<Parttime> {

    public List<Parttime> getParttimeByIntroducer(Introducer introducer);

    public Parttime getPattimeDetail(Parttime parttime);

    public List<ParttimePerson> getParttimePerson(String Id);

    public void addParttime(Parttime parttime);

    public void changeStudentStatus(ParttimePerson parttimePerson);

    public void cancelApplication(Parttime parttime);

}
