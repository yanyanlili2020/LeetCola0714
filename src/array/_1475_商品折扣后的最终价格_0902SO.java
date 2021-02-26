package array;

/**
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，
 * 那么你可以得到与 prices[j] 相等的折扣，
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，
 * 如果没有满足条件的 j，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格
 */
public class _1475_商品折扣后的最终价格_0902SO {
 class zx {
     public int[] finalPrices(int[] prices) {
         int[] ans=new int[prices.length];
         a:
         for(int i=0;i<prices.length;i++){
             for(int j=i+1;j<prices.length;j++){
                 if(prices[j] <= prices[i]){
                 ans[i]=prices[i]-prices[j];
                 continue a;}
    
                 }
             ans[i]=prices[i];
         }
         return ans;
     }
 }
    class Solution {
        public int[] finalPrices(int[] prices) {
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] <= prices[i]) {
                        prices[i] = prices[i] - prices[j];
                        break;
                    }
                }
            }
            return prices;
        }
    }

}
