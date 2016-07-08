package dao;

import entity.StockChange;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hjc on 16-7-3.
 */

public interface IStockChangeDao {
    public boolean add(StockChange stockChange);
    //增加库存变化清单

    public StockChange findFromId(String stock_change_id) throws SQLException;
    //跟据库存变化id查找清单

    public List<StockChange> findAll() throws SQLException;
    //查找所有库存变化清单

    public List<StockChange> findFromDay(Timestamp timestamp) throws SQLException;
    //查找某一天所有的的库存变化清单

    public List<StockChange> findFromFlag(int change_flag) throws SQLException;
    //跟据进出货查找订单
}
