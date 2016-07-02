package test;

import org.junit.*;
import utils.TransTimestamp;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by hjc on 16-7-1.
 */
public class TestTest {
    @org.junit.Test
    public void test1() throws Exception {

            Timestamp timestamp1 = TransTimestamp.YMDToTimestamp(2016,7,2);
            Timestamp timestamp2 = TransTimestamp.stringToTimestamp("2016-7-1 22:03:30");
            String day = TransTimestamp.timestampToDayString(timestamp1);
            String sec = TransTimestamp.timestampToSecString(timestamp1);
            System.out.println(day);
            System.out.println(sec);

    }

}