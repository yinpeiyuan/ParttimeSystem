package com.example.demo.controller;

import com.example.demo.mapper.StudentParttimeDao;
import com.example.demo.pojo.ParttimePerson;
import com.example.demo.pojo.ParttimeStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    public StudentParttimeDao studentParttimeDao;

    @RequestMapping("/student")
    public String studentView(Model model, HttpServletRequest request){
        HttpSession session =request.getSession();


        List<ParttimeStudent> list = studentParttimeDao.parttimeDoList((String) session.getAttribute("account"));
        model.addAttribute("parttimeDoList",list);
        System.out.println(list);
            return "student";
    }
    @RequestMapping("/shenqingjianzhi")
    public String shenqingjianzhi(Model model,HttpServletRequest request){
HttpSession session =request.getSession();
        String account =(String) session.getAttribute("account");
       List<ParttimeStudent> list = studentParttimeDao.parttimeList(account);
       model.addAttribute("account",account);
       model.addAttribute("parttimeList",list) ;
        System.out.println(list);
       return "shenqingjianzhi";
    }

    @RequestMapping("/shenqingjianzhiStatus")
    @ResponseBody
    public String shenqingjianzhiStatus(ParttimePerson parttimePerson){

        studentParttimeDao.shenqingjianzhiStatus(parttimePerson);
        return "申请成功";
    }

    @RequestMapping("/changeStupartttimeStatus")
    @ResponseBody
    public String changeStuPartttimeStatus(ParttimePerson parttimePerson){

        studentParttimeDao.changeStupartttimeStatus(parttimePerson);
        return "success";
    }



}
