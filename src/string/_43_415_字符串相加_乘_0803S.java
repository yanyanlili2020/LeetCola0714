package string;

/***
 *
 * https://leetcode-cn.com/problems/multiply-strings/solution/
 */
public class _43_415_字符串相加_乘_0803S {
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int add = 0;
            StringBuffer ans = new StringBuffer();
            while(i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            // 计算完以后的答案需要翻转过来
            ans.reverse();
            return ans.toString();
        }
    }
    class _43 {
        class Solution30ms {
            public String multiply(String num1, String num2) {
                if(num1.equals("0") || num2.equals("0")) {
                    return "0";
                }
                String ans = "0";
                int m = num1.length(), n = num2.length();
                for(int i = n - 1; i >= 0; i--) {
                    StringBuffer curr = new StringBuffer();
                    int add = 0;
                    for(int j = n - 1; j > i; j--) {
                        curr.append(0);
                    }
                    int y = num2.charAt(i) - '0';
                    for(int j = m - 1; j >= 0; j--) {
                        int x = num1.charAt(j) - '0';
                        int product = x * y + add;
                        curr.append(product % 10);
                        add = product / 10;
                    }
                    if(add != 0) {
                        curr.append(add % 10);
                    }
                    ans = addStrings(ans, curr.reverse().toString());
                }
                return ans;
            }
            public String addStrings(String num1, String num2) {
                int i = num1.length() - 1, j = num2.length() - 1, add = 0;
                StringBuffer ans = new StringBuffer();
                while(i >= 0 || j >= 0 || add != 0) {
                    int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                    int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                    int result = x + y + add;
                    ans.append(result % 10);
                    add = result / 10;
                    i--;
                    j--;
                }
                ans.reverse();
                return ans.toString();
            }
        }
        class Solution2ms {
            public String multiply(String num1, String num2) {
                if(num1.length() == 0 || num2.length() == 0) {
                    return "";
                } else if("0".equals(num1) || "0".equals(num2)) {
                    return "0";
                }
                char[] number1 = num1.toCharArray();
                char[] number2 = num2.toCharArray();
                int[] result = new int[number1.length + number2.length];
                int start = 0;
                for(int i = number1.length - 1; i >= 0; i--) {
                    int d = number1[i] - '0';
                    int k = start;
                    for(int j = number2.length - 1; j >= 0; j--) {
                        result[k++] += (number2[j] - '0') * d;
                    }
                    start++;
                }
                int rem = 0;
                for(int i = 0; i < result.length; i++) {
                    result[i] += rem;
                    rem = result[i] / 10;
                    result[i] %= 10;
                }
                StringBuilder sb = new StringBuilder();
                int i = number1.length + number2.length - 1;
                while(result[i] == 0)
                    i--;
                while(i >= 0) {
                    sb.append(result[i]);
                    i--;
                }
                return sb.toString();
            }
        }
    }
}
