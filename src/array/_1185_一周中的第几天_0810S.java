package array;
/***
 * https://leetcode-cn.com/problems/day-of-the-week/
 */

import java.time.LocalDateTime;

public class _1185_一周中的第几天_0810S {
    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
//            基姆拉尔森计算公式 把一月和二月看成是上一年的十三月和十四月
            if(month == 1 || month == 2) {
                month += 12;
                year--;
            }
            int i = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
            String[] result = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            return result[i];
        }
    }
    class Solution2 {
        private final String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday"};
        public String dayOfTheWeek(int day, int month, int year) {
            return days[LocalDateTime.of(year, month, day, 0, 0).getDayOfWeek().getValue() % 7];
        }
    }
}

