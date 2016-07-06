package service.system;

import dao.impl.StockChangeDao;
import entity.StockChange;
import service.system.frontBean.Repertory;
import utils.TransTimestamp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjc on 16-7-5.
 */
public class Repertorys {

    private Repertory findFromStockChange(StockChange stockChange){
        Repertory repertory = new Repertory();

        repertory.setCommodityClassName(stockChange.getCommodity_class());
        repertory.setCommodityName(stockChange.getCommodity_name());
        repertory.setScale(stockChange.getCommodity_standard());
        repertory.setNumber(stockChange.getPackage_number());
        repertory.setDate(TransTimestamp.timestampToSecString(stockChange.getChange_date()));
        repertory.setStatus(stockChange.getChange_flag()==1?"出货":"进货");
        repertory.setChargePersonName(stockChange.getCharge_person());

        return repertory;
    }

    public List<Repertory> findAll() throws SQLException {
        //查找所有Repertory
        StockChangeDao stockChangeDao = new StockChangeDao();
        List<StockChange> stockChangeList = stockChangeDao.findAll();
        List<Repertory> repertoryList = new ArrayList<Repertory>();
        for(StockChange stockChange : stockChangeList){
            Repertory repertory = this.findFromStockChange(stockChange);
            repertoryList.add(repertory);
        }
        return repertoryList;
    }

    public List<Repertory> findFromName(String commodityName) throws SQLException {
        //根据商品名查找
        StockChangeDao stockChangeDao = new StockChangeDao();
        List<StockChange> stockChangeList = stockChangeDao.findAll();
        List<Repertory> repertoryList = new ArrayList<Repertory>();
        for(StockChange stockChange : stockChangeList){
            if(stockChange.getCommodity_name().equals(commodityName)) {
                Repertory repertory = this.findFromStockChange(stockChange);
                repertoryList.add(repertory);
            }
        }
        return repertoryList;
    }
}
