package dao.impl;

import dao.IIndentDao;
import entity.Indent;
import utils.JdbcUtils;
import utils.TransTimestamp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hjc on 16-7-2.
 */
public class IndentDao implements IIndentDao {
    @Override
    public boolean add(Indent indent) {
        //增加订单
        String sql = "INSERT INTO indent (indent_id,buyer_id,order_time,deadline,goods,total_price,remark,clearing_form,clearing_status) VALUES(";
        sql+="'"+indent.getIndent_id()+"',";
        sql+="'"+indent.getBuyer_id()+"',";
        sql+="'"+indent.getOrder_time()+"',";
        sql+="'"+indent.getDeadline()+"',";
        sql+="'"+indent.getGoods()+"',";
        sql+="'"+indent.getTotal_price()+"',";
        sql+="'"+indent.getRemark()+"',";
        sql+="'"+indent.getClearing_form()+"',";
        sql+="'"+indent.getClearing_status()+"'";
        sql+=");";

        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean delete(Indent indent) {
        //跟据订单对象删除订单
        String sql = "DELETE FROM indent WHERE indent_id = '"+indent.getIndent_id()+"'";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public boolean deleteFromId(String indent_id) {
        //跟据订单id删除订单
        String sql = "DELETE FROM indent WHERE indent_id = '"+indent_id+"'";
        return JdbcUtils.exeSql(sql);
    }

    @Override
    public Indent findFromIndent_id(String indent_id) throws SQLException {
        //跟据订单id
        String sql = "SELECT * FROM indent WHERE indent_id = '"+indent_id+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        Indent indent = null;
        if(rs.next()){
            indent = new Indent();
            indent.setIndent_id(rs.getString("indent_id"));
            indent.setBuyer_id(rs.getString("buyer_id"));
            indent.setOrder_time(rs.getTimestamp("order_time"));
            indent.setDeadline(rs.getTimestamp("deadline"));
            indent.setGoods(rs.getString("goods"));
            indent.setTotal_price(rs.getDouble("total_price"));
            indent.setRemark(rs.getString("remark"));
            indent.setClearing_form(rs.getString("clearing_form"));
            indent.setClearing_status(rs.getInt("clearing_status"));
        }
        return indent;
    }

    @Override
    public List<Indent> findFromBuyer_id(String buyer_id) throws SQLException {
        //跟据购买者的id查找订单(倒序)
        String sql = "SELECT * FROM indent WHERE buyer_id = '"+buyer_id+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        List<Indent> list = new LinkedList<Indent>();
        Indent indent = null;
        while(rs.next()){
            indent = new Indent();
            indent.setIndent_id(rs.getString("indent_id"));
            indent.setBuyer_id(rs.getString("buyer_id"));
            indent.setOrder_time(rs.getTimestamp("order_time"));
            indent.setDeadline(rs.getTimestamp("deadline"));
            indent.setGoods(rs.getString("goods"));
            indent.setTotal_price(rs.getDouble("total_price"));
            indent.setRemark(rs.getString("remark"));
            indent.setClearing_form(rs.getString("clearing_form"));
            indent.setClearing_status(rs.getInt("clearing_status"));
            list.add(indent);
        }
        return list;
    }

    @Override
    public List<Indent> findAllIndent() throws SQLException{
        //查询所有订单(倒序)
        String sql = "SELECT * FROM indent";
        ResultSet rs = JdbcUtils.exeSqlQuery(sql);
        List<Indent> list = new ArrayList<Indent>();
        Indent indent = null;
        while(rs.next()){
            indent = new Indent();
            indent.setIndent_id(rs.getString("indent_id"));
            indent.setBuyer_id(rs.getString("buyer_id"));
            indent.setOrder_time(rs.getTimestamp("order_time"));
            indent.setDeadline(rs.getTimestamp("deadline"));
            indent.setGoods(rs.getString("goods"));
            indent.setTotal_price(rs.getDouble("total_price"));
            indent.setRemark(rs.getString("remark"));
            indent.setClearing_form(rs.getString("clearing_form"));
            indent.setClearing_status(rs.getInt("clearing_status"));
            list.add(indent);
        }
        return list;
    }

    @Override
    public List<Indent> findFromAfterOneday(Timestamp time) throws SQLException {
        //查询某一天及之前的订单(正序)
        String day = TransTimestamp.timestampToDayString(time);
        List<Indent> list = findAllIndent();
        List<Indent> resultList = new LinkedList<Indent>();
        for(int i=list.size()-1;i>=0;--i){
            String someDay = TransTimestamp.timestampToDayString(list.get(i).getOrder_time());
            if(someDay.compareTo(day)>=0){
                resultList.add(list.get(i));
            }else{
                break;
            }
        }
        return resultList;
    }

    @Override
    public List<Indent> findFromStatus(int status) throws SQLException {
        //跟据订单结算情况查询订单（倒序）,0是未结清，1是已结清?
        List<Indent> list = new ArrayList<Indent>();
        if(status==0||status==1){
            String sql = "SELECT * FROM indent WHERE clearing_status = '"+status+"';";
            ResultSet rs = JdbcUtils.exeSqlQuery(sql);
            Indent indent = new Indent();
            list = new LinkedList<Indent>();
            while(rs.next()){
                indent = new Indent();
                indent.setIndent_id(rs.getString("indent_id"));
                indent.setBuyer_id(rs.getString("buyer_id"));
                indent.setOrder_time(rs.getTimestamp("order_time"));
                indent.setDeadline(rs.getTimestamp("deadline"));
                indent.setGoods(rs.getString("goods"));
                indent.setTotal_price(rs.getDouble("total_price"));
                indent.setRemark(rs.getString("remark"));
                indent.setClearing_form(rs.getString("clearing_form"));
                indent.setClearing_status(rs.getInt("clearing_status"));
                list.add(indent);
            }

        }
        return list;
    }

    @Override
    public List<Indent> findFromDeadline(Timestamp time) throws SQLException {
        //查找某一天截至的订单（正序）
        String day = TransTimestamp.timestampToDayString(time);
        List<Indent> list = findAllIndent();
        List<Indent> resultList = new LinkedList<Indent>();
        boolean tag = false;
        for(int i=list.size()-1;i>=0;--i){
            String someDay = TransTimestamp.timestampToDayString(list.get(i).getDeadline());
            if(someDay.equals(day)){
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
    public boolean changeStatus(String indent_id,int status){
        //跟据订单id，把某一订单的结算情况改为status
        String sql = "UPDATE indent SET clearing_status = '"+status+"' WHERE indent_id = '"+indent_id+"';";
        return JdbcUtils.exeSql(sql);
    }
}
