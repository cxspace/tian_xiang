package utils;

import java.util.Random;

/**
 * Created by cxspace on 16-7-1.
 */
public class WebUtils {

    /*
         产生一个len位长度的id号

     */

    public static String getRandomId(int len) {
        StringBuffer sb = new StringBuffer();

        Random r = new Random();

        for (int i = 0; i < len; i++) {
            sb.append(r.nextInt(10));
        }

        return sb.toString();

    }



}
