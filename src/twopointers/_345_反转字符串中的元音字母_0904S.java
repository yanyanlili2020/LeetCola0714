package twopointers;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class _345_反转字符串中的元音字母_0904S {
    class Solution2 {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = s.length() - 1;
            while(i < j) {
                while(i < j && !valid(chars[i])) {
                    i++;
                }
                while(i < j && !valid(chars[j])) {
                    j--;
                }
                if(i < j) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                }
            }
            return new String(chars);
        }
        public boolean valid(char c) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return true;
            }
            return false;
        }
    }
    class Solution18 {
        public String reverseVowels(String s) {
            if(s == null || s.length() == 0) {
                return s;
            }
            String vowels = "aeiouAEIOU";
            // 将字符串转化成char类型数组
            char[] chars = s.toCharArray();
            int start = 0;
            int end = s.length() - 1;
            while(start < end) {
                // 双指针相向而行找元音字符
                while(start < end && !vowels.contains(chars[start] + "")) {
                    start++;
                }
                while(start < end && !vowels.contains(chars[end] + "")) {
                    end--;
                }
                swap(chars, start, end);
                start++;
                end--;
            }
            return new String(chars);
        }
        private void swap(char[] chars, int start, int end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
    }
}
