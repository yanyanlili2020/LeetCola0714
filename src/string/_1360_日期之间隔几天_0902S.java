package string;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * https://leetcode-cn.com/problems/number-of-days-between-two-dates/
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 */
public class _1360_日期之间隔几天_0902S {
    // 日期均转成1970年后多少天 然后相减
    class Solution {
        public int toDay(String dateStr) {
            String[] temp = dateStr.split("-");
            int year = Integer.valueOf(temp[0]);
            int month = Integer.valueOf(temp[1]);
            int day = Integer.valueOf(temp[2]);
        
            if (month <= 2) {
                year--;
                month += 10;
            }
            else month -= 2;
            return 365 * year + year / 4 - year / 100 + year / 400 + 30 * month + (3 * month - 1) / 5 + day /*- 584418*/;
        }
        public int daysBetweenDates(String date1, String date2) {
            return Math.abs(toDay(date1) - toDay(date2));
        }
    }
    class Solution1 {
        public int daysBetweenDates(String date1, String date2) {
            int year1 = Integer.parseInt(date1.substring(0,4));
            int year2 = Integer.parseInt(date2.substring(0,4));
            int m1 = Integer.parseInt(date1.substring(5,7));
            int m2 = Integer.parseInt(date2.substring(5,7));
            int d1 = Integer.parseInt(date1.substring(8));
            int d2 = Integer.parseInt(date2.substring(8));
            if(year1 > year2 ||(year1==year2 && m1 > m2) ||
                    (year1==year2 && m1 == m2 && d1 > d2)){
                year1 = Integer.parseInt(date2.substring(0,4));
                year2 = Integer.parseInt(date1.substring(0,4));
                m1 = Integer.parseInt(date2.substring(5,7));
                m2 = Integer.parseInt(date1.substring(5,7));
                d1 = Integer.parseInt(date2.substring(8));
                d2 = Integer.parseInt(date1.substring(8));
            }
            int res = 0;
            for(int i=year1;i<year2;i++){
                res += (i%4==0 && i%100!=0) || i%400 == 0?366:365;
            }
            
            res += g(m2,year2) + d2;
            res -= g(m1,year1) + d1;
            return res;
        }
        public int g(int n,int y){
            int res = 0;
            switch(n){
                case 12:
                    res += 30;
                case 11:
                    res += 31;
                case 10:
                    res += 30;
                case 9:
                    res += 31;
                case 8:
                    res += 31;
                case 7:
                    res += 30;
                case 6:
                    res += 31;
                case 5:
                    res += 30;
                case 4:
                    res += 31;
                case 3:
                    res += (y%4==0 && y%100!=0) || y%400 == 0?29:28;
                case 2:
                    res += 31;
            }
            return res;
        };
    }

    class Solution9 {
        public int daysBetweenDates(String date1, String date2) {
            // 日期函数差值比较
            LocalDate startDate = LocalDate.parse(date1);
            
            LocalDate endDate = LocalDate.parse(date2);
            
            long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
            return Math.abs((int)daysDiff);
        }
    }
    
}
