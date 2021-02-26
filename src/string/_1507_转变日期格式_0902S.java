package string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/reformat-date
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 *     Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 *     Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}
 *     中的一个元素。
 *     Year 的范围在 [1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 *     YYYY 表示 4 位的年份。
 *     MM 表示 2 位的月份。
 *     DD 表示 2 位的天数。
 */
public class _1507_转变日期格式_0902S {
    class Solution11 {
        public String reformatDate(String date) {
            String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            Map<String, Integer> s2month = new HashMap<String, Integer>();
            for (int i = 1; i <= 12; i++) {
                s2month.put(months[i - 1], i);
            }
            String[] array = date.split(" ");
            int year = Integer.parseInt(array[2]);
            int month = s2month.get(array[1]);
            int day = Integer.parseInt(array[0].substring(0, array[0].length() - 2));
            return String.format("%d-%02d-%02d", year, month, day);
        }
    }
    class Solution1 {
        public String reformatDate(String date) {
            StringBuilder sb = new StringBuilder();
            int idx = date.indexOf(' ');
            int idx2 = date.lastIndexOf(' ');
            String year = date.substring(idx2 + 1, date.length());
            String month = to_month(date.substring(idx + 1, idx2));
            sb.append(year).append('-').append(month).append('-');
            if(date.charAt(1)>96 && date.charAt(1)<123)
                sb.append('0').append(date.charAt(0));
            else
                sb.append(date.charAt(0)).append(date.charAt(1));
            return String.valueOf(sb);
        }
        
        private String to_month(String str){
            switch (str){
                case "Jan": return "01";
                case "Feb": return "02";
                case "Mar": return "03";
                case "Apr": return "04";
                case "May": return "05";
                case "Jun": return "06";
                case "Jul": return "07";
                case "Aug": return "08";
                case "Sep": return "09";
                case "Oct": return "10";
                case "Nov": return "11";
                case "Dec": return "12";
            }
            return "";
        }
    }

}
