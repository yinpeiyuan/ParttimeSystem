package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.InterfaceParttimeDao;
import com.example.demo.pojo.Introducer;
import com.example.demo.pojo.Parttime;
import com.example.demo.pojo.ParttimePerson;
import com.example.demo.service.impl.InterfaceParttimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class IntroducerController {
    @Autowired
    InterfaceParttimeService interfaceParttimeService;

    @Autowired
    private InterfaceParttimeDao interfaceParttimeDao;



    @InitBinder
    public void InitBinder(HttpServletRequest request,
                           ServletRequestDataBinder binder) {
        // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
        // SimpleDateFormat dateFormat = new
        // SimpleDateFormat(getText("date.format", request.getLocale()));
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
                dateFormat, true));
    }


    @RequestMapping("introducer")
    public  String introducerHtml(Model model,HttpServletRequest httpServletRequest){
        Introducer introducer = new Introducer();
        HttpSession session = httpServletRequest.getSession();
        String account = (String)session.getAttribute("account");
        introducer.setAccount(account);
        List<Parttime> parttime= interfaceParttimeService.getParttimeByIntroducer(introducer);
        System.out.println(parttime);
        model.addAttribute("introducer_id",account);
        model.addAttribute("parttimeJob",parttime);
        return "jieshaoren";
    }
    @RequestMapping("/getParttimePerson")
    @ResponseBody
        public List<ParttimePerson> getParttimePerson( String Id) {

        return interfaceParttimeService.getParttimePerson(Id);
    }
    @RequestMapping("/addParttime")
    @ResponseBody
    public String  addParttime(Parttime parttime){
        interfaceParttimeDao.addParttime(parttime);

        return "添加成功";
    }

    @RequestMapping("/changeStudentStatus")
    @ResponseBody
    public String changeStudentStatus(ParttimePerson parttimePerson){
        System.out.println(parttimePerson);
        interfaceParttimeDao.changeStudentStatus(parttimePerson);
        return "success";
    }
    @RequestMapping("/cancelApplication")
    @ResponseBody
    public  String cancelApplication(Parttime parttime){
        interfaceParttimeDao.cancelApplication( parttime);

        return "success";

    }





//    @RequestMapping("/getParttimeDetail")
//    @ResponseBody
//    public String getParttimeDetailz(@PathVariable String Id){
//        Parttime parttime=new Parttime();
//        parttime.setId(Id);
//
//
//
//
//    }


    @RequestMapping("/get")
    @ResponseBody
    public String get(Introducer introducer) {
        List<Parttime> parttime= interfaceParttimeService.getParttimeByIntroducer(introducer);

        return JSONObject.toJSONString(parttime);
    }



}
