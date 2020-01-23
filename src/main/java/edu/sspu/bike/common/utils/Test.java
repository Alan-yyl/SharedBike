package edu.sspu.bike.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther 杨亚龙
 * @date 2019/11/16 14:57
 */
public class Test {
    @org.junit.Test
    public static void main(String[] args) {
        String listString ="[10,20,30,50.2632155152]";
        String numStr = listString.subSequence(1, listString.length() - 1).toString();
        int endIndex = numStr.lastIndexOf(",");
        Double endNum = Double.parseDouble(numStr.subSequence(endIndex + 1, numStr.length()).toString().trim());
        System.out.println(endNum);
    }
    // public static void main(String args[]) {
    //     String str = "[ ]";
    //     String pattern = "[ ]";
    //
    //     Pattern r = Pattern.compile(pattern);
    //     Matcher m = r.matcher(str);
    //     System.out.println(m.matches());
    // }
}
