package string;

/**
 * https://leetcode-cn.com/problems/bulls-and-cows/
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 * <p>
 * 链接：https://leetcode-cn.com/problems/master-mind-lcci/
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。
 * 作为用户，你试图猜出颜色组合。
 * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；
 * 要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，
 * 返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 */
public class _299_1615_猜数字_0830S {
    class _299 {
        class Solution1 {
            public String getHint(String secret, String guess) {
                StringBuffer res = new StringBuffer();
                int A = 0, B = 0, Aa[] = new int[10], Bb[] = new int[10];
                for(int i = 0; i < secret.length(); ++i) {
                    if(secret.charAt(i) == guess.charAt(i)) A++;
                    else {
                        Aa[secret.charAt(i) - '0']++;
                        Bb[guess.charAt(i) - '0']++;
                    }
                }
                for(int i = 0; i < 10; ++i) {
                    B += Math.min(Aa[i], Bb[i]);
                }
                return res.append(A).append("A").append(B).append("B").toString();
            }
        }
        class Solution6 {
            public String getHint(String secret, String guess) {
                int A = 0;
                int B = 0;
                int[] num = new int[10]; // 存储出现数字的个数(数字为下标, 个数为值)
                for(int i = 0; i < secret.length(); i++) {
                    if(secret.charAt(i) == guess.charAt(i)) A++; // 数字&&位置相等，公牛++
                    else {
                        // 更新数组
                        // 如果不相等则每次将 答案 和 猜测 记录到数组中
                        if(num[(int) (secret.charAt(i) - '0')]++ < 0) {
                            B++; // 记录增加第i位数字的个数, 注:如果此时比0小则母牛++
                        }
                        if(num[(int) (guess.charAt(i) - '0')]-- > 0) {
                            B++; // 记录减少第i位数字的个数，注:如果此时比0大则母牛++
                        }
                        // 数组中每个数字默认是0, 然后遍历时判断个数的变化记录母牛
                    }
                }
                String s = A + "A" + B + "B";
                return s;
            }
        }
    }
    class _m1615 {
        class Solution {
            public int[] masterMind(String solution, String guess) {
                int hit = 0; //猜中
                int udohit = 0; //伪猜中
                char[] sc = solution.toCharArray();
                char[] gc = guess.toCharArray();
                int[] dict = new int[128];
                for(int i = 0; i < gc.length; i++) {
                    if(gc[i] == sc[i]) {
                        gc[i] = '/'; //表示已经猜过了
                        hit++;
                    }
                    else {
                        dict[sc[i]]++;//剩余未猜中的建字典，类似set,用来做伪猜中.
                    }
                }
                for(int i = 0; i < gc.length; i++) {
                    if(dict[gc[i]] > 0) {
                        dict[gc[i]]--; //伪猜中后，应猜字符数减少
                        udohit++;
                    }
                }
                return new int[]{hit, udohit};
            }
        }
    }
}
