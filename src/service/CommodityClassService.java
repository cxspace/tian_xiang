package service;

import dao.impl.CommodityClassDao;
import entity.CommodityClass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by cxspace on 16-7-4.
 */
public class CommodityClassService {

    public static List<CommodityClass> findAllCommodityClass(){

        List<CommodityClass> allCommodityClass  = new ArrayList<CommodityClass>();

        CommodityClassDao commodityClassDao = new CommodityClassDao();

        try {
            allCommodityClass = commodityClassDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allCommodityClass;
    }
}
