package com.example.demo.service.impl;

import com.example.demo.mapper.InterfaceParttimeDao;
import com.example.demo.pojo.Introducer;
import com.example.demo.pojo.Parttime;
import com.example.demo.pojo.ParttimePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class InterfaceParttimeService {
    @Autowired
    private InterfaceParttimeDao interfaceParttimeDao;

    public List<Parttime> getParttimeByIntroducer(Introducer introducer){
        return interfaceParttimeDao.getParttimeByIntroducer(introducer);
    }

    public List<ParttimePerson> getParttimePerson(String Id) {

        return interfaceParttimeDao.getParttimePerson(Id);
    }
}
