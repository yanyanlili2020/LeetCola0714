package array;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），
 * 和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 */
public class _605_种花问题_0814S {
    class Solution {
/*      我们从左到右扫描数组 flowerbed，如果数组中有一个 0，并且这个 0 的左右两侧都是 0，那么我们就可以在这个位置种花，
        即将这个位置的 0 修改成 1，并将计数器 count 增加 1。对于数组的第一个和最后一个位置，我们只需要考虑一侧是否为 0。
        在扫描结束之后，我们将 count 与 n 进行比较。如果 count >= n，那么返回 True，否则返回 False。*/
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            for(int i = 0;i < flowerbed.length;i++) {
                if((flowerbed[i] == 0)
                        && ((i == 0)
                            || (flowerbed[i - 1] == 0))
                        && ((i == (flowerbed.length - 1))
                            || (flowerbed[i + 1] == 0))) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            return count >= n;
        }
    }
    class Solutionyouhua {
        /*在扫描数组 flowerbed 时，如果 count 的值已经达到 n，那么我们可以直接跳出循环并返回 True。*/
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            for(int i = 0;i < flowerbed.length;i++) {
                if((flowerbed[i] == 0)
                        && ((i == 0)
                        || (flowerbed[i - 1] == 0))
                        && ((i == (flowerbed.length - 1))
                        || (flowerbed[i + 1] == 0))) {
                    flowerbed[i] = 1;
                    count++;
                }
                if(count>=n) {
                    return true;
                }
            }
            return false;
        }
    }
}

