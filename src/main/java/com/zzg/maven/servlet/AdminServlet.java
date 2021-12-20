package com.zzg.maven.servlet;

import com.alibaba.fastjson.JSON;
import com.zzg.maven.DAO.AdminDAO;
import com.zzg.maven.DAO.impl.AdminDAOImpl;
import com.zzg.maven.result.AJAXResult;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String s = split[split.length - 1];
        if (s.equals("login")) {
            login(req, resp);
        }else if (s.equals("get")){
            get(req, resp);
        }
    }

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object admin = req.getSession().getAttribute("admin");
        AJAXResult s=new AJAXResult(20001,"获取成功",admin);
        String json = JSON.toJSONString(s);
        resp.getWriter().write(json);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, Object> login = adminDAO.login(username, password);
        req.getSession().setAttribute("admin", login);
        PrintWriter out = resp.getWriter();
        if (login == null) {
            AJAXResult result = new AJAXResult(50001, "对不起账号或密码有误", null);
            String s = JSON.toJSONString(result);
            out.write(s);
        }else{
            Object admin = req.getSession().getAttribute("admin");
            AJAXResult result = new AJAXResult(20001, "成功登录", admin);
            String s = JSON.toJSONString(result);
            out.write(s);
        }

    }
}
