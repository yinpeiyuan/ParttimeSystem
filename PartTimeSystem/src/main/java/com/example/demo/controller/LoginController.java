package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;
import org.n3r.idworker.Id;
import org.n3r.idworker.IdWorker;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;



//    @Autowired
//    private Sid sid;
//
//    @RequestMapping("tologin")
//    public String toLogin(){
//        return "login";
//    }
//
//    @RequestMapping("toRegister")
//    public String toRegister(String type, ModelMap map){
//        return "register";
//    }
//
//    @RequestMapping("login")
//    public String login(String username, String password, String type, ModelMap map){
//        map.addAttribute("msg", "hello");
//        System.out.println(username + "::" + password);
//        System.out.println("type:" + type);
//        return "success";
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    @RequestMapping("toSignUp")
//    public String signUp(User user){
//        user.setId(sid.nextShort());
//        loginService.saveUser(user);
//        System.out.println(user.getName());
//        return "login";
//    }
//



}
