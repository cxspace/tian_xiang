package service.system;

import dao.impl.CommodityClassDao;
import dao.impl.CommodityDao;
import entity.Commodity;
import entity.CommodityClass;
import service.system.frontBean.Good;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjc on 16-7-5.
 */
public class Goods {
    private Good findFromCommodity(Commodity commodity) throws SQLException {
        CommodityClassDao commodityClassDao = new CommodityClassDao();

        Good good = new Good();

        String goodClassName = commodityClassDao.findFromId(commodity.getCommodity_class_cc_id()).getCc_name();
        String goodName = commodity.getC_name();
        String goodId = commodity.getC_id();
        double goodPrice = commodity.getC_price();

        good.setGoodClassName(goodClassName);
        good.setGoodName(goodName);
        good.setGoodId(goodId);
        good.setGoodPrice(goodPrice);

        return good;
    }

    public List<Good> allGood() throws SQLException {
        //查询所有Good
        CommodityClassDao commodityClassDao = new CommodityClassDao();
        CommodityDao commodityDao = new CommodityDao();

        List<Good> goodList = new ArrayList<Good>();
        List<CommodityClass> commodityClassList = commodityClassDao.findAll();
        for(CommodityClass commodityClass : commodityClassList){
            List<Commodity> commodityList = commodityDao.findFromCc_id(commodityClass.getCc_id());
            for(Commodity commodity : commodityList){
                Good good = findFromCommodity(commodity);
                goodList.add(good);
            }
        }
        return goodList;
    }

    public boolean deleteGood(String goodId) throws SQLException {
        //跟据Good的Id删除商品
        CommodityDao commodityDao = new CommodityDao();
        Commodity commodity = commodityDao.findFromC_Id(goodId);
        return commodityDao.delete(commodity);
    }

    public boolean changePrice(String goodId,double goodPrice) throws SQLException {
        //根据goodPrice和goodId改变商品价格
        CommodityDao commodityDao = new CommodityDao();
        Commodity commodity = commodityDao.findFromC_Id(goodId);
        commodity.setC_price((float)goodPrice);
        return commodityDao.update(commodity);
    }
}
