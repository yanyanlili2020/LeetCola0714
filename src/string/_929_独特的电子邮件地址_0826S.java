package string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-email-addresses
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），
 * 则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com”
 * 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。
 * 这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * 可以同时使用这两个规则。
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 */
public class _929_独特的电子邮件地址_0826S {
    class Solution6 {
        public int numUniqueEmails(String[] emails) {
            int size = emails.length;
            int count = 0;
            Set<String> set = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String addr = emails[i];// 可以省掉
                String newAddr = restore(addr);
                if(!set.contains(newAddr)) {
                    set.add(newAddr);
                    count++;
                }
            }
            return count;
        }
        private String restore(String addr) {
            int len = addr.length();
            StringBuilder restored = new StringBuilder();
            int index = addr.indexOf('@');          // 定位 @
            for(int i = 0; i < index; i++) {
                char ch = addr.charAt(i);
                if(ch == '+') break;             // '+' 后面的内容全部忽略
                if(ch == '.') continue;          // '.' 忽略
                restored.append(ch);
            }
            restored.append(addr.substring(index));
            return restored.toString();
        }
    }
    class Solution9 {
        String deal(String s) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();
            int i = 0;
            char ch = 0;
            while(i < len && (ch = s.charAt(i)) != '@') {
                ++i;
                if('.' == ch) {
                    continue;
                }
                else if('+' == ch) {
                    while(i < len && s.charAt(i) != '@') {
                        ++i;
                    }
                    break;
                }
                else {
                    sb.append(ch);
                }
            }
            while(i < len) {
                sb.append(s.charAt(i++));
            }
            return sb.toString();
        }
        public int numUniqueEmails(String[] emails) {
            HashSet<String> set = new HashSet<>();
            for(String s : emails) {
                set.add(deal(s));
            }
            return set.size();
        }
    }
    class Solution27 {
        public int numUniqueEmails(String[] emails) {
            Set<String> seen = new HashSet();
            for(String email : emails) {
                int i = email.indexOf('@');
                String local = email.substring(0, i);
                String rest = email.substring(i);
                if(local.contains("+")) {
                    local = local.substring(0, local.indexOf('+'));
                }
                local = local.replaceAll("\\.", "");
                seen.add(local + rest);
            }
            return seen.size();
        }
    }
}
