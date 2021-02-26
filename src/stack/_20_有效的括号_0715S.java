package stack;

import java.util.HashMap;
import java.util.Stack;

/***
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 *      输入: "()"
 *      输出: true
 */
public class _20_有效的括号_0715S {
    // solution4 用数组实现栈 0ms
    class Solution4 {
        public boolean isValid4(String s) {
            if(s == null || s.length() == 0) return true;
            int len = s.length();// 定义字符串的长度
            char[] c = new char[len];// 以字符串的长度建立数组 来实现栈
            char[] sc = s.toCharArray();// 将字符串转为字符数组
            int top = 0;//指向栈最顶层元素
            int index = 0;
            c[top] = sc[index];//相当于 c[0]=sc[0]
            index++;//index指向下一个待匹配元素
            while(index < sc.length) {
                //栈不为空时执行匹配操作
                if(top > -1 &&
                        ((sc[index] == '}' && c[top] == '{') ||
                                (sc[index] == ')' && c[top] == '(') ||
                                (sc[index] == ']' && c[top] == '['))) {
                    top--;
                    index++;
                }
                else {
                    top++;
                    c[top] = sc[index];
                    index++;
                }
            }
            return top == -1 ? true : false;
        }
    }
    // solution1 效率低 66ms
    class Solution1 {
        public boolean isValid1(String s) {
            while(s.contains("{}")
                    || s.contains("[]")
                    || s.contains("()")) {
                s = s.replace("{}", "");
                s = s.replace("()", "");
                s = s.replace("[]", "");
            }
            return s.isEmpty();
        }
    }
    // solution2 栈 2ms 击败了80.28%
    class Solution2 {
        public boolean isValid2(String s) {
            Stack<Character> stack = new Stack<>();// 放字符的包装类
            int len = s.length();// 字符串的length()是方法，数组的length是属性
            for(int i = 0; i < len; i++) {
                char c = s.charAt(i);
//      for(char c : s.toCharArray()){  上两行可换为
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);// 读到左括号就入栈
                }
                else { // 读到右括号
                    if(stack.isEmpty()) return false;// 栈为空，返回false
                    char left = stack.pop();// 弹出一个括号 进行匹配
                    if(left == '(' && c != ')') return false;
                    if(left == '{' && c != '}') return false;
                    if(left == '[' && c != ']') return false;
                }
            }
            return stack.isEmpty();
        }
    }
    // solution3 栈 哈希 2ms
    static class Solution3 {
        private static HashMap<Character, Character> map = new HashMap<>();
        static {// 对静态map 静态初始化
            // key - value
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');
        }
        public boolean isValid3(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            for(int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if(map.containsKey(c)) { // 左括号
                    stack.push(c);
                }
                else { // 右括号
                    if(stack.isEmpty()) return false;
                    if(c != map.get(stack.pop())) return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
