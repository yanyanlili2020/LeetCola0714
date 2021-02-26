package math;

/***
 * https://leetcode-cn.com/problems/maximum-69-number/
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * 请返回你可以得到的最大数字。
 * 示例 1：
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * 示例 2：
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * 示例 3：
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 * 提示：
 *     1 <= num <= 10^4
 *     num 每一位上的数字都是 6 或者 9 。
 */
// 思路：把遇到的第一个6换成9
public class _1323_6和9组成的最大数字_0717S {
    // 1 ms
    public int maximum69Number1 (int num) {
        char[] arr = String.valueOf(num).toCharArray();// 将数字转化为字符串 再转为字符数组
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;// 遇到6就换为9
            }
        }
        return Integer.parseInt(String.valueOf(arr));// 将字符数组转化为字符串 再转化为整数
}
    // 10 ms
    public int maximum69Number2 (int num) {
        String s = num + "";// num转字符串
        s = s.replaceFirst("6", "9");// 用9替换6
        return Integer.valueOf(s);// 将字符串转为整数
//        return Integer.parseInt(String.valueOf(s)); 替换后没有耗时差异
    }
    // 0 ms
    public int maximum69Number3 (int num) {
        int maxSixPos = 0;
        int n = 1;
        int tem = num;
        while (tem != 0) {
            n = n * 10;
            if (tem % 10 == 6) {
                maxSixPos = n;
            }
            tem = tem / 10;
        }
        if (maxSixPos == 0) {
            return num;
        }
        return (num / maxSixPos) * maxSixPos + (num % (maxSixPos / 10)) + 9 * (maxSixPos / 10);
    }
}
