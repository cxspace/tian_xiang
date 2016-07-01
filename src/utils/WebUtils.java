package utils;

import java.util.Random;

/**
 * Created by cxspace on 16-7-1.
 */
public class WebUtils {

    /*
         产生一个12位长度的id号

     */

    public static String getRandomId() {
        StringBuffer sb = new StringBuffer();

        Random r = new Random();

        for (int i = 0; i < 12; i++) {
            sb.append(r.nextInt(10));
        }

        return sb.toString();

    }



}
