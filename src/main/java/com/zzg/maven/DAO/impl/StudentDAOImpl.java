package com.zzg.maven.DAO.impl;

import com.zzg.maven.DAO.StudentDAO;
import com.zzg.maven.entity.Student;
import com.zzg.maven.util.DAOUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Map<String, Object>> lsit() {
        String sql = "SELECT s.id,s.name,s.age,s.address,c.grade FROM student s INNER JOIN t_class c where s.grade=c.id";

        return DAOUtil.request(sql);
    }

    @Override
    public int delStu(String id) {
        String sql = "DELETE FROM student s WHERE id=?";
        return DAOUtil.update(sql,id);
    }

    @Override
    public int addStu(Student student) {
        String sql = "INSERT INTO student values(null,?,?,?,?)";
        return DAOUtil.update(sql,student.getName(),student.getAge(),student.getAddress(),student.getGrade());
    }

    @Override
    public Map<String, Object> getStu(String id) {
        String sql = "SELECT * from student where id=?";
        List<Map<String, Object>> request = DAOUtil.request(sql,id);
        if (request.size() > 0) {
            return request.get(0);
        }
        return null;
    }

    @Override
    public int updateStu(Student student) {
        String sql = "update student set name=?,age=?,address=?,grade=? where id=? ";
        return DAOUtil.update(sql,student.getName(),student.getAge(),student.getAddress(),student.getGrade(),student.getId());
    }
}
