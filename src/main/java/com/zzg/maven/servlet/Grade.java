package com.zzg.maven.servlet;

import com.alibaba.fastjson.JSON;
import com.zzg.maven.DAO.GradeDAO;
import com.zzg.maven.DAO.impl.GradeDAOImpl;
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
@WebServlet("/grade/*")
public class Grade extends HttpServlet {
   private GradeDAO grade=new GradeDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];
        if (s.equals("list")) {
            list(req, resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> lsit = grade.lsit();
        AJAXResult ajaxResult=new AJAXResult(200,"查询班级成功",lsit);
        String s = JSON.toJSONString(ajaxResult);
        resp.getWriter().write(s);

    }
}
