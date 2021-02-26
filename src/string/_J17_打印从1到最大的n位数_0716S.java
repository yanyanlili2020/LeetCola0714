package string;

/***
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 *     用返回一个整数列表来代替打印
 *     n 为正整数
 */
public class _J17_打印从1到最大的n位数_0716S {
    public int[] printNumbers(int n) {
        if(n < 1) return null;
        int max = 1;// 求最大值-边界
        while(n >= 1){
            max *= 10;
            n--;
        }
        int[] result = new int[max-1];
        for(int i = 0;i < max-1;i++){
            result[i] = i+1;
        }
        return result;
    }
}
