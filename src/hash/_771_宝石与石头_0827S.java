package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class _771_宝石与石头_0827S {
    class Solution1ms {
        public int numJewelsInStones(String J, String S) {
            int cnt = 0;
            char[] Jc = J.toCharArray();
            for(int i = 0; i < Jc.length; i++) {
                for(char c : S.toCharArray()) {
                    if(c == Jc[i]) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
    class Solutio2ms {
        public int numJewelsInStones(String J, String S) {
            int ans = 0;
            for(char s : S.toCharArray()) {
                for(char j : J.toCharArray()) {
                    if(j == s) {
                        ans++;
                        break; // Stop searching whether this stone 's' is a jewel
                    }
                }
            }
            return ans;
        }
    }
    class Solution2ms2 {
        public int numJewelsInStones(String J, String S) {
            Set<Character> Jset = new HashSet();
            for(char j : J.toCharArray()) {
                Jset.add(j);
            }
            int ans = 0;
            for(char s : S.toCharArray()) {
                if(Jset.contains(s)) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
