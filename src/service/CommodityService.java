package service;

import dao.impl.CommodityDao;
import entity.Commodity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by cxspace on 16-7-4.
 */
public class CommodityService {


    public static List<Commodity> findAllCommodity(String cc_id) throws SQLException {

        CommodityDao commodityDao = new CommodityDao();

        List<Commodity> allCommodities = commodityDao.findFromCc_id(cc_id);

        return allCommodities;
    }

    public static Commodity findCommodityById(String c_id) throws Exception{
        CommodityDao commodityDao = new CommodityDao();

        Commodity commodity = commodityDao.findFromC_Id(c_id);

        return commodity;
    }
}
