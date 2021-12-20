package com.zzg.maven.servlet;

import com.alibaba.fastjson.JSON;
import com.zzg.maven.DAO.StudentDAO;
import com.zzg.maven.DAO.impl.StudentDAOImpl;
import com.zzg.maven.entity.Student;
import com.zzg.maven.result.AJAXResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/stu/*")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];
        if (s.equals("list")) {
            list(req, resp);
        } else if (s.equals("delStu")) {
            delStu(req, resp);
        } else if (s.equals("addStu")) {
            addStu(req, resp);
        }else if (s.equals("getStu")){
            getStu(req, resp);
        }else if (s.equals("updateStu")){
            updateStu(req, resp);
        }
    }


    protected void updateStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String grade = req.getParameter("grade");
        Student student = new Student(Integer.parseInt(id), name, Integer.parseInt(age), address, grade);
        int stu = studentDAO.updateStu(student);

        AJAXResult result=new AJAXResult(200,"修改成功",stu);
        String s = JSON.toJSONString(result);
        resp.getWriter().write(s);

    }

    protected void getStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Map<String, Object> stu = studentDAO.getStu(id);
        AJAXResult result=new AJAXResult(200,"查询成功",stu);
        String s = JSON.toJSONString(result);
        resp.getWriter().write(s);


    }

    protected void addStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String grade = req.getParameter("grade");
        Student student = new Student(0, name, Integer.parseInt(age), address, grade);
        int i = studentDAO.addStu(student);
        AJAXResult arrayList = new AJAXResult(200, "添加成功", i);
        String s = JSON.toJSONString(arrayList);
        resp.getWriter().write(s);
    }

    protected void delStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = studentDAO.delStu(id);
        AJAXResult ajaxResult = new AJAXResult(200, "删除成功", i);
        String s = JSON.toJSONString(ajaxResult);
        resp.getWriter().write(s);

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> lsit = studentDAO.lsit();
        AJAXResult ajaxResult = new AJAXResult(200, "查询成功", lsit);
        String s = JSON.toJSONString(ajaxResult);
        resp.getWriter().write(s);
    }
}
