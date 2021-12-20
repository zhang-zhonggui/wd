package com.zzg.maven.DAO;

import com.zzg.maven.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {
    List<Map<String, Object>> lsit();

    int delStu(String id);

    int addStu(Student student);

    Map<String, Object> getStu(String id);

    int updateStu(Student student);
}
