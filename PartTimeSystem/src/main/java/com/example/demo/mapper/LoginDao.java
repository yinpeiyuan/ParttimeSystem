package com.example.demo.mapper;

import com.example.demo.pojo.Parttime;
import com.example.demo.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LoginDao extends MyMapper<Parttime> {
    public Map getInstructorPassword(String username);

    public Map getStudentPassword(String username);

    public Map getIntroducerPassword(String username);

    public void  insertJieshaoren(@Param("ID_nu") String ID_nu ,@Param("name") String name,@Param("position") String position,@Param("username") String username,@Param("password") String password);

    public int selectStu_nu(String stu_nu);

    public void  registerStudent(@Param("username") String username,@Param("password") String password,@Param("stu_nu") String stu_nu);


}
