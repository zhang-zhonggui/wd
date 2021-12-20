package com.zzg.maven.DAO.impl;


import com.zzg.maven.DAO.GradeDAO;
import com.zzg.maven.util.DAOUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class GradeDAOImpl implements GradeDAO {
    @Override
    public List<Map<String, Object>> lsit() {
        String sql = "select * from t_class";
        return DAOUtil.request(sql);
    }
}
