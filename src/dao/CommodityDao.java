package dao;

import entity.Commodity;
import utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hjc on 16-7-2.
 */
public class CommodityDao implements ICommodityDao {

    @Override
    public boolean add(Commodity commodity){
        //通过商品对象增加商品
        String sql = "INSERT INTO commodity (c_id,c_name,commodity_class_cc_id,c_number,c_picture,c_price,c_vip_price,c_describe) VALUES(";
        sql+="'"+commodity.getC_id()+"',";
        sql+="'"+commodity.getC_name()+"',";
        sql+="'"+commodity.getCommodity_class_cc_id()+"',";
        sql+="'"+commodity.getC_number()+"',";
        sql+="'"+commodity.getC_picture()+"',";
        sql+="'"+commodity.getC_price()+"',";
        sql+="'"+commodity.getC_vip_price()+"',";
        sql+="'"+commodity.getC_describe()+"'";
        sql+=");";

        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean delete(Commodity commodity) {
        //通过商品对象删除商品
        String sql = "DELETE FROM commodity WHERE c_id = '"+commodity.getC_id()+"'";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean delete(String c_id) {
        //通过商品id删除商品
        String sql = "DELETE FROM commodity WHERE c_id = '"+c_id+"'";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean update(Commodity commodity) {
        //更改某个id的商品
        String sql = "UPDATE commodity SET ";
        sql+="c_name = '"+commodity.getC_name()+"' ";
        sql+="c_number = '"+commodity.getC_number()+"' ";
        sql+="c_picture = '"+commodity.getC_picture()+"' ";
        sql+="c_price = '"+commodity.getC_price()+"' ";
        sql+="c_vip_price = '"+commodity.getC_vip_price()+"' ";
        sql+="c_describe = '"+commodity.getC_describe()+"' ";
        sql+="WHERE c_id = '"+commodity.getC_id()+"';";

        return JdbcUtils.exeSql(sql);
    }

    @Override
    public Commodity findFromC_Id(String c_id) throws SQLException {
        //通过商品id查找商品
        String sql = "SELECT * FROM commodity WHERE c_id = '"+c_id+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        Commodity c = null;
        if(rs.next()){
            c = new Commodity();
            c.setC_id(rs.getString("c_id"));
            c.setC_name(rs.getString("c_name"));
            c.setCommodity_class_cc_id(rs.getString("commodity_class_cc_id"));
            c.setC_number(rs.getInt("c_number"));
            c.setC_picture(rs.getString("c_picture"));
            c.setC_price(rs.getFloat("c_price"));
            c.setC_vip_price(rs.getFloat("c_vip_price"));
            c.setC_describe(rs.getString("c_describe"));

        }
        return c;
    }

    @Override
    public List<Commodity> findFromCc_id(String commodity_class_cc_id) throws SQLException {
        //通过商品类别id查找商品
        String sql = "SELECT * FROM commodity WHERE commodity_class_cc_id = '"+commodity_class_cc_id+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        List<Commodity> list = new LinkedList<Commodity>();
        Commodity c = new Commodity();
        while(rs.next()){
            c.setC_id(rs.getString("c_id"));
            c.setC_name(rs.getString("c_name"));
            c.setCommodity_class_cc_id(rs.getString("commodity_class_cc_id"));
            c.setC_number(rs.getInt("c_number"));
            c.setC_picture(rs.getString("c_picture"));
            c.setC_price(rs.getFloat("c_price"));
            c.setC_vip_price(rs.getFloat("c_vip_price"));
            c.setC_describe(rs.getString("c_describe"));
            list.add(c);
        }
        return list;
    }

    @Override
    public Commodity findFromC_name(String c_name) throws SQLException {
        //通过商品名查找商品
        String sql = "SELECT * FROM commodity WHERE c_name = '"+c_name+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        Commodity c = null;
        if(rs.next()){
            c = new Commodity();
            c.setC_id(rs.getString("c_id"));
            c.setC_name(rs.getString("c_name"));
            c.setCommodity_class_cc_id(rs.getString("commodity_class_cc_id"));
            c.setC_number(rs.getInt("c_number"));
            c.setC_picture(rs.getString("c_picture"));
            c.setC_price(rs.getFloat("c_price"));
            c.setC_vip_price(rs.getFloat("c_vip_price"));
            c.setC_describe(rs.getString("c_describe"));

        }
        return c;
    }
}
