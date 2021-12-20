package com.zzg.maven.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * @DateTime: 2021/11/27 9:58
 * @Description: 将公共部分进行封装
 * @Author: zzg
 */
public class DAOUtil {
    private  static DataSource  dataSource=null;

    static {
        try {
            //加载驱动
            Properties properties = new Properties();
            InputStream is = DAOUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            if (is != null){
                properties.load(is);
            }else{
                System.out.println(1);
            }
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //连接数据库
        return dataSource.getConnection();
    }

    /**
     * @param sql 查询的sql语句
     * @param obj 查询所需的条件
     * @return List<Map>的数据
     * 获取传入的数据，然后对数据库进行操作，返回List<Map>的数据
     */
    public static List<Map<String, Object>> request(String sql, Object... obj) {
        Connection conn = null;
        try {
            conn = DAOUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            List<Map<String, Object>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < md.getColumnCount(); i++) {
                    map.put(md.getColumnName(i + 1), rs.getObject(i + 1));
                }
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param sql 查询的sql语句
     * @param obj 需要修改的参数
     * @return 看数据是否修改成功
     */
    public static int update(String sql, Object... obj) {
        Connection conn = null;
        try {
            conn = DAOUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

}
