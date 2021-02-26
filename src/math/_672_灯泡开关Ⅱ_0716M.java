package math;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.min;

/***
 * https://leetcode-cn.com/problems/bulb-switcher-ii/
 * 现有一个房间，墙上挂有 n 只已经打开的灯泡和 4 个按钮。
 * 在进行了 m 次未知操作后，你需要返回这 n 只灯泡可能有多少种不同的状态。
 * 假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下：
 *     将所有灯泡的状态反转（即开变为关，关变为开）
 *     将编号为偶数的灯泡的状态反转
 *     将编号为奇数的灯泡的状态反转
 *     将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
 * 示例 1:
 * 输入: n = 1, m = 1.
 * 输出: 2
 * 说明: 状态为: [开], [关]
 * 示例 2:
 * 输入: n = 2, m = 1.
 * 输出: 3
 * 说明: 状态为: [开, 关], [关, 开], [关, 关]
 * 示例 3:
 * 输入: n = 3, m = 1.
 * 输出: 4
 * 说明: 状态为: [关, 开, 关], [开, 关, 开], [关, 关, 关], [关, 开, 开].
 * 注意： n 和 m 都属于 [0, 1000].
 */
public class _672_灯泡开关Ⅱ_0716M {
/** 方法一：减少搜索空间 [通过]
    由于搜索空间非常大（2^N 个灯光的状态，4^M 个操作顺序 ），让我们尝试减少它。
    前6个灯唯一地决定了其余的灯。这是因为每一个修改 第 x 的灯光的操作都会修改第 (x+6) 的灯光。
    另外：进行 A 操作后接 B 操作 和 B 操作后接 A 操作是一样的，所以我们可以假设我们按顺序进行所有操作。
    最后，连续两次执行相同的操作与不执行任何操作相同。所以我们只需要考虑每个操作是 0 次还是 1 次。
 */
    public int flipLights(int n, int m) {
        Set<Integer> seen = new HashSet();
        n = min(n, 6);
        int shift = Math.max(0, 6-n);
        for (int cand = 0; cand < 16; ++cand) {
            int bcount = Integer.bitCount(cand);
            if (bcount % 2 == m % 2 && bcount <= m) {
                int lights = 0;
                if (((cand >> 0) & 1) > 0) lights ^= 0b111111 >> shift;
                if (((cand >> 1) & 1) > 0) lights ^= 0b010101 >> shift;
                if (((cand >> 2) & 1) > 0) lights ^= 0b101010 >> shift;
                if (((cand >> 3) & 1) > 0) lights ^= 0b100100 >> shift;
                seen.add(lights);
            }
        }
        return seen.size();
}
/** 方法二：
 * 因为前 6 个灯唯一地决定了其余的灯。
 * 这是因为修改第 x 灯光的每个操作都会修改 第 (x+6) 灯光。
 * 实际上，前 3 个灯唯一地确定了序列的其余部分，如下表所示，用于执行操作 a, b, c, d:
 * Light 1 = 1 + a + c + d
 * Light 2 = 1 + a + b
 * Light 3 = 1 + a + c
 * Light 4 = 1 + a + b + d
 * Light 5 = 1 + a + c
 * Light 6 = 1 + a + b
 * 假设操作1实现了a次，操作2实现了b次, 操作3实现了c次, 操作4实现了d次, 那么:
 * Light 1 状态 = (1+a+c+d) %2
 * Light 2 状态 = (1+a+b) %2
 * Light 3 状态 = (1+a+c) %2
 * Light 4 状态 = (1+a+b+d) %2
 * 当灯泡1==灯泡3时，即d为偶数, 则灯泡2==灯泡4
 * 当灯泡1 !=灯泡3时，即d为奇数, 则灯泡2!=灯泡4
 * 也就是灯泡1和灯泡3可以决定灯泡4, 即前3个灯泡可以决定所有灯泡状态
 * 上述理由表明，在不损失一般性的情况下，取 n=min(n,3) 是合理的。
 * 让我们用 (a,b,c)来表示灯的状态。与值为 (1,1,1),(0,1,0),(1,0,1),(1,0,0)xor.异或
    因为前 6 个灯唯一地决定了其余的灯。
    当 m=0 时，所有灯都亮起，只有一个状态(1,1,1)。在这种情况下，答案总是 1。
    当 m=1 时，我们可以得到状态 (0,0,0), (1,0,1),(0,1,0),(0,1,1)。在这种情况下，对于 n=1,2,3 的答案是 2,3,4。
    当 m=2 时，我们可以检查是否可以获得 7 个状态：除(0,1,1)之外的所有状态。在这种情况下，n=1,2,3 的答案是 2,4,7。
    当 m=3 时，我们可以得到所有 8 个状态。在这种情况下，n=1,2,3 的答案是 2,4,8。
*/
    public int flipLights2(int n, int m) {
        n = min(n, 3);
        if (m == 0)
            return 1;
        if (m == 1)
            return n == 1 ? 2 : n == 2 ? 3 : 4;
        if (m == 2)
            return n == 1 ? 2 : n == 2 ? 4 : 7;
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }
/**方法三：
 * 灯的状态是会重复的，只用分析前面四个灯的状态就可以了，
 * 例如 5号肯定和3号状态一致， 6号肯定和2号状态一致，
 * 1 7
 * 2 6 8
 * 3 5 9
 * 4   10
 */
    public int flipLights3(int n, int m) {
        if(n==0)return 0;
        if(n>=3){
            return min(8, 1+m*3);
        }
        if(n==1){
            return min(2,1+m);
        }
        if(n==2){
            return min(4,1+m*2);
        }
        return 0;
    }

    public int flipLights4(int n, int m) {
        if (m == 0) return 1;
        if (n == 1) return 2;
        else if(n == 2)
                if(m == 1) return 3;
                else return 4;
        else if(n >= 3)
                if(m == 1) return 4;
                else if(m == 2) return 7;
        return 8;
    }
}