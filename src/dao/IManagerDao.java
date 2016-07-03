package dao;

import entity.Manager;

import java.sql.SQLException;

/**
 * Created by hjc on 16-7-3.
 */
public interface IManagerDao {
    public Manager findFromName(String manager_name) throws SQLException;
    //跟据用户名查找Manager
}
