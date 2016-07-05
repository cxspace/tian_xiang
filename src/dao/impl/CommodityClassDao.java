package dao.impl;

import dao.ICommodityClassDao;
import entity.CommodityClass;
import utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjc on 16-7-2.
 */
public class CommodityClassDao implements ICommodityClassDao {
    @Override
    public boolean add(CommodityClass commodityClass) {
        //添加商品类
        String sql = "INSERT INTO commodity_class (cc_id,cc_name) VALUES ('"+commodityClass.getCc_id()+"','"+commodityClass.getCc_name()+"');";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean delete(CommodityClass commodityClass) {
        //通过商品类对象删除商品类
        String sql = "DELETE FROM commodity_class WHERE cc_id = '"+commodityClass.getCc_id()+"'";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean deleteFromId(String cc_id) {
        //通过商品类id删除商品类
        String sql = "DELETE FROM commodity_class WHERE cc_id = '"+cc_id+"'";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean update(CommodityClass commodityClass) {
        //更改某个id的商品类别
        String sql = "UPDATE commodity_class SET cc_name = '"+commodityClass.getCc_name()+"' WHERE cc_id = '"+commodityClass.getCc_id()+"'";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public CommodityClass findFromId(String commodityClassId) throws SQLException {
        //通过id查找CommodityClass对象
        String sql = "SELECT * FROM commodity_class WHERE cc_id = '"+commodityClassId+"'";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        CommodityClass commodityclass = null;
        if(rs.next()){
            commodityclass = new CommodityClass();
            commodityclass.setCc_id(rs.getString("cc_id"));
            commodityclass.setCc_name(rs.getString("cc_name"));
        }
        return commodityclass;
    }

    @Override
    public CommodityClass findFromName(String commodityName) throws SQLException {
        //通过commodity_name查找CommodityClass对象
        String sql = "SELECT * FROM commodity_class WHERE cc_name = '"+commodityName+"'";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        CommodityClass commodityclass = null;
        if(rs.next()){
            commodityclass = new CommodityClass();
            commodityclass.setCc_id(rs.getString("cc_id"));
            commodityclass.setCc_name(rs.getString("cc_name"));
        }
        return commodityclass;
    }



    @Override
    public List<CommodityClass> findAll() throws SQLException {

        String sql = "SELECT * FROM commodity_class;";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        List<CommodityClass> allClasses = new ArrayList<CommodityClass>();

        while (rs.next()){

            CommodityClass commodityClass = new CommodityClass();
            commodityClass.setCc_id(rs.getString("cc_id"));
            commodityClass.setCc_name(rs.getString("cc_name"));

            allClasses.add(commodityClass);
        }

        return allClasses;
    }
}
