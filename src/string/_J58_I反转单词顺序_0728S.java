package string;

/***
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 */
public class _J58_I反转单词顺序_0728S {
    public String reverseWords(String s) {
        if(s == null) return s;
        s = s.trim();// 删除首尾空格
        String[] stringList = s.split(" ");// 分割字符串
        StringBuilder result = new StringBuilder();
        for(int i = stringList.length - 1; i >= 0; i--) {// 倒序遍历单词列表
            if(stringList[i].equals("")) continue;// 遇到空单词则跳过
            if(i == 0) result.append(stringList[i].trim());
            else result.append(stringList[i].trim()).append(" ");// 将单词拼接至 StringBuilder
        }
        return  result.toString();// 转化为字符串
    }
}
/**
 *
 */
