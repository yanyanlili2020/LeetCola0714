package bit;

/**
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 */
public class _405_数字转换为十六进制数_0823S {
    class Solution {
        // 调用类库
        public String toHex(int num) {
            return Integer.toHexString(num);
        }
    }
    class Solution0ms {
        public String toHex(int num) {
            StringBuffer buffer = new StringBuffer();
            char[] arr ="0123456789abcdef".toCharArray();
            if(num==0) return "0";
            while (num!=0){
                int tmp=num&15;
                buffer.append(arr[tmp]);
                num=num>>>4;
            }
            return buffer.reverse().toString();
        }
    }
 class Solution11ms {
     public String toHex(int num) {

         char[] hex = "0123456789abcdef".toCharArray();
         String s = new String();
         while(num != 0){
             int end = num&15;
             s = hex[end] + s;
             //无符号右移
             num >>>=4;
         }
         if(s.length() == 0){
             s = "0";
         }

         return s;
     }

 }
}
