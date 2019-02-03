package com.example.demo.controller;

import com.example.demo.mapper.InstructorDao;
import com.example.demo.mapper.StudentParttimeDao;
import com.example.demo.pojo.Introducer;
import com.example.demo.pojo.Parttime;
import com.example.demo.pojo.ParttimeStudent;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.dnd.DragGestureEvent;
import java.util.List;

@Controller
public class InstructorController {
    @Autowired
    public InstructorDao instructorDao;
    @Autowired
    public StudentParttimeDao studentParttimeDao;



    @RequestMapping("/index")
    public String  showInstructor(Model model,HttpServletRequest requestAll){
        HttpSession session =requestAll.getSession();
        String account = (String )session.getAttribute("account");
        List<Student> studentList = instructorDao.selectStudent(account);


        model.addAttribute("studentList",studentList);
        return "index";
    }

    @ResponseBody
    @RequestMapping("getAllParttime")
    public List<Parttime> getAllParttime(String stu_nu){
       return instructorDao.selectParttime(stu_nu);
    }


    @RequestMapping("/lookjianzhi")
    public  String lookjianzhi(Model model){
        String account ="1513042054";
        List<ParttimeStudent> list = instructorDao.parttimeList2(account);

        model.addAttribute("parttimeList",list) ;
        return  "lookjianzhi";
    }

    @RequestMapping("/deleteParttime")
    @ResponseBody
    public  String deleteParttime(Parttime parttime){
        System.out.println(parttime);
        instructorDao.deleteParttime(parttime);
        return "success";
    }


    @RequestMapping("/evaluate")
    public String evaluate(Model model){

        List<Introducer> list =instructorDao.selectIntroducer();
        model.addAttribute("IntroducerList",list);
        return "evaluatePerson";
    }

    @RequestMapping("changeIntroducerStatus")
    @ResponseBody
    public String changeIntroducerStatus(Introducer introducer){
        System.out.println(introducer);
        instructorDao.changeIntroducerStatus(introducer);
        return "success";
    }

    @RequestMapping("addStudent")
    @ResponseBody
    public String addStudent(Student student,HttpServletRequest request){
        HttpSession session =request.getSession();
        String account = (String)session.getAttribute("account");
        student.setInstructor_id(account);
        instructorDao.addStudent(student);
        System.out.println(student);
        return  "success";
    }

    @RequestMapping("editStudent")
    @ResponseBody
    public  String editStudent(Student student){
        System.out.println(student);
        instructorDao.editStudent(student);
        return "success";
    }
    @RequestMapping("deleteStudent")
    @ResponseBody
    public String deleteStudent(String stu_nu){
        instructorDao.deleteStudent(stu_nu);
        return "success";
    }



}
