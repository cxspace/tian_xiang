package dao;

import entity.Indent;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hjc on 16-7-2.
 */
public interface IIndentDao {
    public boolean add(Indent indent);
    //增加商品订单

    public boolean delete(Indent indent);
    //删除订单

    public boolean deleteFromId(String indent_id);
    //根据订单id删除订单

    public Indent findFromIndent_id(String indent_id) throws SQLException;
    //跟据订单id查找商品

    public List<Indent> findFromBuyer_id(String buyer_id) throws SQLException;
    //跟据购买者id，查找其所有订单

    public List<Indent> findAllIndent() throws SQLException;
    //查询所有订单

    public List<Indent> findFromAfterOneday(Timestamp time) throws SQLException;
    //查找某一天以前定下的所有订单

    public List<Indent> findFromStatus(int status) throws SQLException;
    //查找已结清或未结清的订单0未结清，1已结清

    public List<Indent> findFromDeadline(Timestamp time) throws SQLException;
    //查找某一截至日期的订单

    public boolean changeStatus(String indent_id,int status);
    //跟据订单id，把某一订单结算情况变为已结清
}
