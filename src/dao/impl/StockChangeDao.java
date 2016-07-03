package dao.impl;

import dao.IStockChangeDao;
import entity.StockChange;
import utils.JdbcUtils;
import utils.TransTimestamp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hjc on 16-7-3.
 */
public class StockChangeDao implements IStockChangeDao{
    @Override
    public boolean add(StockChange stockChange){
        //增加库存变化清单
        String sql = "INSERT INTO stock_change (stock_change_id,commodity_class,commodity_name,commodity_standard,package_number,change_date,change_flag,charge_person) VALUES(";
        sql+="'"+stockChange.getStock_change_id()+"',";
        sql+="'"+stockChange.getCommodity_class()+"',";
        sql+="'"+stockChange.getCommodity_name()+"',";
        sql+="'"+stockChange.getCommodity_standard()+"',";
        sql+="'"+stockChange.getPackage_number()+"',";
        sql+="'"+stockChange.getChange_date()+"',";
        sql+="'"+stockChange.getChange_flag()+"',";
        sql+="'"+stockChange.getCharge_person()+"'";
        sql+=");";

        return JdbcUtils.exeSql(sql);
    }

    @Override
    public StockChange findFromId(String stock_change_id) throws SQLException {
        //跟据库存变化id查找清单
        String sql = "SELECT * FROM stock_change WHERE stock_change_id = '"+stock_change_id+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        StockChange stockChange = null;
        if(rs.next()){
            stockChange = new StockChange();
            stockChange.setStock_change_id(rs.getString("stock_change_id"));
            stockChange.setCommodity_class(rs.getString("commodity_class"));
            stockChange.setCommodity_name(rs.getString("commodity_name"));
            stockChange.setCommodity_standard(rs.getInt("commodity_standard"));
            stockChange.setPackage_number(rs.getInt("package_number"));
            stockChange.setChange_date(rs.getTimestamp("change_date"));
            stockChange.setChange_flag(rs.getInt("change_flag"));
            stockChange.setCharge_person(rs.getString("charge_person"));
        }
        return stockChange;
    }

    @Override
    public List<StockChange> findAll() throws SQLException {
        //查找所有库存变化清单
        String sql = "SELECT * FROM stock_change";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        List<StockChange> list = new ArrayList<StockChange>();
        while(rs.next()){
            StockChange stockChange = new StockChange();
            stockChange.setStock_change_id(rs.getString("stock_change_id"));
            stockChange.setCommodity_class(rs.getString("commodity_class"));
            stockChange.setCommodity_name(rs.getString("commodity_name"));
            stockChange.setCommodity_standard(rs.getInt("commodity_standard"));
            stockChange.setPackage_number(rs.getInt("package_number"));
            stockChange.setChange_date(rs.getTimestamp("change_date"));
            stockChange.setChange_flag(rs.getInt("change_flag"));
            stockChange.setCharge_person(rs.getString("charge_person"));
            list.add(stockChange);
        }
        return list;
    }

    @Override
    public List<StockChange> findFromDay(Timestamp timestamp) throws SQLException {
        //查找某一天所有的的库存变化清单
        String day = TransTimestamp.timestampToDayString(timestamp);
        List<StockChange> list = findAll();
        List<StockChange> resultList = new LinkedList<StockChange>();
        for(int i=list.size()-1;i>=0;--i){
            String oneDay = TransTimestamp.timestampToDayString(list.get(i).getChange_date());
            boolean tag = false;
            if(oneDay.equals(day)){
                resultList.add(list.get(i));
                tag=true;
            }else{
                if(tag==true){
                    break;
                }
            }
        }
        return resultList;
    }

    @Override
    public List<StockChange> findFromFlag(int change_flag) throws SQLException {
        //跟据进出货查找所有订单
        if(change_flag==0||change_flag==1){
            String sql = "SELECT * FROM stock_change WHERE change_flag = '"+change_flag+"';";
            ResultSet rs = JdbcUtils.exeSqlQuery(sql);
            List<StockChange> list = new ArrayList<StockChange>();
            while(rs.next()){
                StockChange stockChange = new StockChange();
                stockChange.setStock_change_id(rs.getString("stock_change_id"));
                stockChange.setCommodity_class(rs.getString("commodity_class"));
                stockChange.setCommodity_name(rs.getString("commodity_name"));
                stockChange.setCommodity_standard(rs.getInt("commodity_standard"));
                stockChange.setPackage_number(rs.getInt("package_number"));
                stockChange.setChange_date(rs.getTimestamp("change_date"));
                stockChange.setChange_flag(rs.getInt("change_flag"));
                stockChange.setCharge_person(rs.getString("charge_person"));
                list.add(stockChange);
            }
            return list;
        }else{
            throw new RuntimeException();
        }
    }
}
