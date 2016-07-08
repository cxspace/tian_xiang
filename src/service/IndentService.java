package service;

import dao.impl.IndentDao;
import entity.Indent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxspace on 16-7-5.
 */
public class IndentService {
    public static List<Indent> findByUserId(String userId) throws SQLException{
        List<Indent> allIndents = new ArrayList<Indent>();

        IndentDao indentDao = new IndentDao();

        allIndents = indentDao.findFromBuyer_id(userId);

        return allIndents;
    }

    public static boolean deleteIndent(String indentId){
        boolean flag = false;

        IndentDao indentDao = new IndentDao();

        flag = indentDao.deleteFromId(indentId);

        return flag;
    }
}
