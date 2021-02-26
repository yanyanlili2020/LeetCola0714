package math;

/**
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class _J20_表示数值的字符串_0902M {
    class Solution2 {
        public boolean isNumber(String s) {
            if(s == null || s.length() == 0) return false;
            //去掉首位空格
            s = s.trim();
            boolean numFlag = false;
            boolean dotFlag = false;
            boolean eFlag = false;
            for(int i = 0; i < s.length(); i++) {
                //判定为数字，则标记numFlag
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numFlag = true;
                    //判定为.  需要没出现过.并且没出现过e
                }
                else if(s.charAt(i) == '.' && !dotFlag && !eFlag) {
                    dotFlag = true;
                    //判定为e，需要没出现过e，并且出过数字了
                }
                else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                    eFlag = true;
                    numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                    //判定为+-符号，只能出现在第一位或者紧接e后面
                }
                else if((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    //其他情况，都是非法的
                }
                else {
                    return false;
                }
            }
            return numFlag;
        }
    }
    class Solution3_2 {
        public boolean isNumber(String s) {
            s = s.trim();
            if(s.length() == 0) return false;
            int index = s.length();
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'e' || s.charAt(i) == 'E')
                    index = i;
            }
            if(index == s.length()) return isNum(s);
            if(index == s.length() - 1) return false;
            if(index == 0) return false;
            return isNum(s.substring(0, index)) && isInteger(s.substring(index + 1));
        }
        private boolean isNum(String s) {
            int i = 0;
            boolean flag = false;
            if(s.charAt(0) == '+' || s.charAt(0) == '-') i++;
            int point = 0;
            for(; i < s.length(); i++) {
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    flag = true;
                    continue;
                }
                else if(s.charAt(i) == '.') {
                    point++;
                }
                else return false;
                if(point > 1) return false;
            }
            return flag;
        }
        private boolean isInteger(String s) {
            int i = 0;
            boolean flag = false;
            if(s.charAt(0) == '+' || s.charAt(0) == '-') i++;
            for(; i < s.length(); i++) {
                if(s.charAt(i) < '0' || s.charAt(i) > '9')
                    return false;
                else
                    flag = true;
            }
            return flag;
        }
    }
    class Solution3 {
        public boolean isNumber(String s) {
            if(s == null || s.length() <= 0) {
                return false;
            }
            boolean isEExist = false;   // 记录 e 和 E 是否存在
            boolean isDotExist = false;   // 记录 小数点 是否存在
            boolean numberic = false;   // 记录 当前数字 是否合法
            char[] chars = s.trim().toCharArray();
            for(int index = 0; index < chars.length; index++) {
                char c = chars[index];
                if(c >= '0' && c <= '9') {
                    numberic = true;
                }
                else if(c == '+' || c == '-') {
                    if(index != 0 && chars[index - 1] != 'e' && chars[index - 1] != 'E') { // 符号只能出现在 首位 和 E/e紧接之后
                        return false;
                    }
                }
                else if(c == '.') {
                    if(isEExist || isDotExist) {
                        return false;
                    }
                    isDotExist = true;
                }
                else if(c == 'E' || c == 'e') {
                    if(isEExist || !numberic) {    // E/e之前必须有数，且没出现过
                        return false;
                    }
                    isEExist = true;
                    numberic = false;
                }
                else {
                    return false;
                }
            }
            return numberic;
        }
    }
}
