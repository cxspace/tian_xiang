package dao.impl;

import dao.IManagerDao;
import entity.Manager;
import utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hjc on 16-7-3.
 */
public class ManagerDao implements IManagerDao {
    @Override
    public Manager findFromName(String manager_name) throws SQLException {
        String sql = "SELECT * FROM manager WHERE manager_name = '"+manager_name+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        Manager manager = null;
        if(rs.next()){
            manager = new Manager();
            manager.setManager_id(rs.getString("manager_id"));
            manager.setManager_name(rs.getString("manager_name"));
            manager.setManager_password(rs.getString("manager_password"));
        }
        return manager;
    }
}
