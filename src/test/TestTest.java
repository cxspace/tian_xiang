package test;

import dao.CommodityClassDao;
import entity.CommodityClass;
import org.junit.*;
import utils.JdbcUtils;
import utils.TransTimestamp;

import java.sql.ResultSet;
import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by hjc on 16-7-1.
 */
public class TestTest {
    @org.junit.Test
    public void test1() throws Exception {
        CommodityClassDao ccDao = new CommodityClassDao();
        CommodityClass cc = new CommodityClass();

        cc.setCc_id("11");
        cc.setCc_name("类");

        ccDao.delete(cc);
    }

}