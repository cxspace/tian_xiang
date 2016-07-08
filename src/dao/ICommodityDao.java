package dao;

import entity.Commodity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hjc on 16-7-2.
 */
public interface ICommodityDao {
    public boolean add(Commodity commodity);
    //增加商品

    public boolean delete(Commodity commodity);
    //通过商品对象删除商品

    public boolean delete(String c_id);
    //通过商品id删除商品

    public boolean update(Commodity commodity);
    //通过商品对象更改商品

    public Commodity findFromC_Id(String c_id) throws SQLException;
    //通过商品id查找商品

    public List<Commodity> findFromCc_id(String cc_id) throws SQLException;
    //通过商品类id查找一类商品

    public Commodity findFromC_name(String c_name) throws SQLException;
    //通过商品名查找商品

    public boolean updateComodityNumber(int crruentNumber);
}
