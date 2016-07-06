package service.system;

import dao.impl.CommodityClassDao;
import dao.impl.CommodityDao;
import entity.Commodity;
import entity.CommodityClass;
import service.system.frontBean.AddGood;
import utils.WebUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hjc on 16-7-6.
 */
public class AddGoods {
    public boolean upDate(AddGood addGood) throws SQLException {
        //增加商品，如果没有这个商品的类别，则创建新类再添加
        CommodityDao commodityDao = new CommodityDao();
        CommodityClassDao commodityClassDao = new CommodityClassDao();

        String addgoodClassName = addGood.getAddGoodClassName();
        List<CommodityClass> commodityClassList = commodityClassDao.findAll();

        CommodityClass commodityClass = null;

        for(CommodityClass commodityClass2 : commodityClassList){
            if(addgoodClassName.equals(commodityClass2.getCc_name())){
                commodityClass = commodityClass2;
                break;
            }
        }
        if(commodityClass == null){
            //没有这个类
            commodityClass = new CommodityClass();
            String commodityClassId = WebUtils.getRandomId(12);
            String commodityClassName = addGood.getAddGoodClassName();
            commodityClass.setCc_id(commodityClassId);
            commodityClass.setCc_name(commodityClassName);
            commodityClassDao.add(commodityClass);
            //添加类别

            Commodity commodity = new Commodity();
            String c_id = WebUtils.getRandomId(12);
            String c_name = addGood.getAddGoodName();
            String commodity_class_cc_id = commodityClassId;
            int c_number = addGood.getAddGoodNumber();
            String c_picture = addGood.getAddGoodPicture();
            float c_price = addGood.getAddGoodPrice();
            float c_vip_price = addGood.getAddGoodVipPrice();
            String c_describe = addGood.getAddGoodDescribe();
            commodity.setC_id(c_id);
            commodity.setC_name(c_name);
            commodity.setCommodity_class_cc_id(commodity_class_cc_id);
            commodity.setC_number(c_number);
            commodity.setC_picture(c_picture);
            commodity.setC_price(c_price);
            commodity.setC_vip_price(c_vip_price);
            commodity.setC_describe(c_describe);
            return commodityDao.add(commodity);
        }else{
            //有这个类
            String addGoodName = addGood.getAddGoodName();
            Commodity commodity = commodityDao.findFromC_name(addGoodName);
            if(commodity==null){
                //有这个类，但没有这个商品
                commodity = new Commodity();
                String c_id = WebUtils.getRandomId(12);
                String c_name = addGood.getAddGoodName();
                String commodity_class_cc_id = commodityClass.getCc_id();
                int c_number = addGood.getAddGoodNumber();
                String c_picture = addGood.getAddGoodPicture();
                float c_price = addGood.getAddGoodPrice();
                float c_vip_price = addGood.getAddGoodVipPrice();
                String c_describe = addGood.getAddGoodDescribe();
                commodity.setC_id(c_id);
                commodity.setC_name(c_name);
                commodity.setCommodity_class_cc_id(commodity_class_cc_id);
                commodity.setC_number(c_number);
                commodity.setC_picture(c_picture);
                commodity.setC_price(c_price);
                commodity.setC_vip_price(c_vip_price);
                commodity.setC_describe(c_describe);
                return commodityDao.add(commodity);
            }else{
                //有这个类也有这个商品
                commodity.setC_number(commodity.getC_number()+addGood.getAddGoodNumber());
                commodity.setC_price(addGood.getAddGoodPrice());
                commodity.setC_vip_price(addGood.getAddGoodVipPrice());
                commodity.setC_picture(addGood.getAddGoodPicture());
                commodity.setC_describe(addGood.getAddGoodDescribe());
                return commodityDao.update(commodity);
            }
        }
    }
}
