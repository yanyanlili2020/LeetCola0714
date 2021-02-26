package array;

/**
 * 链接：https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 */
public class _1491_去掉最低工资和最高工资后的工资平均值_0810S {
    class Solution {
        public double average(int[] salary) {
            int max=1000;
            int min=1000000;
            int sum=0;
            for(int i=0;i<salary.length;i++){
                if(salary[i]>max) max=salary[i];
                if(salary[i]<min) min=salary[i];
                sum+=salary[i];
                
            }
            return (sum-max-min)*1.0/(salary.length-2);
        }
    }
}
