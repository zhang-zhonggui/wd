package com.zzg.maven.DAO;

import java.util.Map;

public interface AdminDAO {
    Map<String, Object> login(String username, String password);
}
