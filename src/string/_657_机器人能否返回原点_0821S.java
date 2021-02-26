package string;

/**
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，
 * 判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。
 * 机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，
 * “L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 */
public class _657_机器人能否返回原点_0821S {
    class Solution3 {
        public boolean judgeCircle(String moves) {
            int[] cnt = new int[26];
            for(char c : moves.toCharArray())
                cnt[c - 'A']++;
            return cnt['L' - 'A'] == cnt['R' - 'A'] && cnt['U' - 'A'] == cnt['D' - 'A'];
        }
    }
    class Solution7 {
        public boolean judgeCircle(String moves) {
            int[] cnt = new int[0x7f];
            for(int i = 0; i < moves.length(); i++) {
                cnt[moves.charAt(i)]++;
            }
            return cnt['R'] == cnt['L'] && cnt['U'] == cnt['D'];
        }
    }
    class Solution5 {
        // 自写简化 将变量减少两个 循环改为foreach 字符串数组匿名
        public boolean judgeCircle(String moves) {
            int x = 0, y = 0;
            for(char move : moves.toCharArray()) {
                if(move == 'U') y--;
                else if(move == 'D') y++;
                else if(move == 'L') x--;
                else if(move == 'R') x++;
            }
            return x == 0 && y == 0;
        }
    }
    class Solution6 {
        // 自写
        public boolean judgeCircle(String moves) {
            char[] move = moves.toCharArray();
            int cntU = 0;
            int cntD = 0;
            int cntL = 0;
            int cntR = 0;
            for(int i = 0; i < move.length; i++) {
                if(move[i] == 'U') cntU++;
                if(move[i] == 'D') cntD++;
                if(move[i] == 'L') cntL++;
                if(move[i] == 'R') cntR++;
            }
            return (cntU == cntD && cntL == cntR);
        }
    }
}
