package com.example.demo.controller;

import com.example.demo.mapper.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginPyinController {

    @Autowired
    LoginDao loginDao;

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return  "register";
    }

    @ResponseBody
    @RequestMapping("toRegister")
    public  String toRegister(String type,String ID_nu ,String name,String position,String username, String password,String stu_nu){
        if(type.equals("1")){
            System.out.println(ID_nu+name+position+username+password);
            loginDao.insertJieshaoren(ID_nu,name,position,username,password);
            return "login";
        }else if(type.equals("2")){
            if(loginDao.selectStu_nu(stu_nu)==0){
                return "学号不存在";
            }else {
                loginDao.registerStudent(username,password,stu_nu);
                return "login";
            }



        }
        return "成功";
    }

    @RequestMapping("tologin")
    @ResponseBody
    public String tologin(String type, String username, String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(type.equals("1")){
            //介绍人

        Map map =loginDao.getIntroducerPassword(username);
            System.out.println(map);
        if(map==null){
            return "用户不存在";
        }else if(!map.get("password").equals(password)){
            return  "密码不正确";
        }else if(map.get("password").equals(password)){
            if(map.get("status").equals("0")){
                return "用户未审核，暂时不能登陆";
            }
            session.setAttribute("account",map.get("account"));
            session.setAttribute("username",map.get("name"));
            return "introducer";
        }






        }else if(type.equals("2")){
            //学生
            Map map =loginDao.getStudentPassword(username);
            
            if(map==null){
                return "用户不存在";
            }else if(!map.get("password").equals(password)){
                return  "密码不正确";
            }else if(map.get("password").equals(password)){
                session.setAttribute("account",map.get("stu_nu"));
                session.setAttribute("username",map.get("name"));
                session.setAttribute("major",map.get("major"));
                return "student";
            }




        }else if(type.equals("3")){
            //教师
            Map map =loginDao.getInstructorPassword(username);
            System.out.println("map---"+map);
            if(map==null){
                return "用户不存在";
            }else if(!map.get("password").equals(password)){
                return  "密码不正确";
            }else if(map.get("password").equals(password)){
                session.setAttribute("account",map.get("account"));
                session.setAttribute("username",map.get("name"));
                session.setAttribute("grade",map.get("grade"));

                return "index";
            }

        }
        System.out.println(type+username+password);
        return "success";

    }

}
