package dao;

import entity.CommodityClass;

import java.sql.SQLException;

/**
 * Created by hjc on 16-7-1.
 */
public interface ICommodityClassDao {

    public boolean add(CommodityClass commodityClass);
    //添加商品类

    public boolean delete(CommodityClass commodityClass);
    //删除商品类

    public boolean deleteFromId(String cc_id);
    //通过商品类别id删除商品

    public boolean update(CommodityClass commodityClass);
    //更改商品类

    public CommodityClass findFromId(String commodityClassId) throws SQLException;
    //通过商品类id查找商品类

    public CommodityClass findFromName(String commodityClassName) throws SQLException;
    //通过商品类名查找商品类
}
