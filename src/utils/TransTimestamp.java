package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by hjc on 16-7-1.
 */
public class TransTimestamp {
    //TransTimestamp与String之间的转换

    public static Timestamp stringToTimestamp(String time){
        //把String转换为Timestamp
        return Timestamp.valueOf(time);
    }

    public static String timestampToSecString(Timestamp timestamp){
        //把Timestamp转换为以秒为精度的String
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(timestamp);
    }

    public static String timestampToDayString(Timestamp timestamp){
        //把Timestamp转换为以天为精度的String
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(timestamp);
    }

    public static Timestamp YMDToTimestamp(int year,int month,int day){
        //接受年月日转化为Timestamp
        String time = year+"-"+month+"-"+day+" 00:00:00";
        return stringToTimestamp(time);
    }


}
