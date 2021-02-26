package string;

/***
 * https://leetcode-cn.com/problems/detect-capital
 */
public class _520_检测大写字母_0729S {
	public boolean detectCapitalUse(String word) {
		char[] chars = word.toCharArray();
		int index = 0, count = 0;
		for(int i = 0; i < chars.length; i++) {
			if('A' <= chars[i] && chars[i] <= 'Z') {
				count++;
				index = i;
			}
		}
		if(count == chars.length || (count == 1 && index == 0))
			return true;
		else return count == 0;
	}
}
/**
 * 将字符串转为字符数组 count记录大写数 index记录大写的下标
 * 遍历数组 如果在大写AZ间 count++ index记录
 * 如果 count=长度 或 count=1 index为0 返回true
 * 或者 count=0 返回true 意味着全小写
 * 其他 false
 */
