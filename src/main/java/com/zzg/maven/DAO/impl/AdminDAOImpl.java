package com.zzg.maven.DAO.impl;

import com.zzg.maven.DAO.AdminDAO;
import com.zzg.maven.util.DAOUtil;


import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class AdminDAOImpl implements AdminDAO {
    @Override
    public Map<String, Object> login(String username, String password) {
        String sql = "SELECT * FROM t_login where username = ? and password = ?";
        List<Map<String, Object>> request = DAOUtil.request(sql, username, password);
        if (request.size() > 0) {
            return request.get(0);
        }
        return null;
    }
}
