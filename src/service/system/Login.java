package service.system;

import dao.impl.ManagerDao;
import entity.Manager;

import java.sql.SQLException;

/**
 * Created by hjc on 16-7-5.
 */
public class Login {
    public Manager findManagerFromName(String managerName) throws SQLException {
        ManagerDao managerDao = new ManagerDao();
        Manager manager = managerDao.findFromName(managerName);
        return manager;
    }
}
