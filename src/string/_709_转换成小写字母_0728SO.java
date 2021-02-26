package string;

/***
 * https://leetcode-cn.com/problems/to-lower-case/
 */
public class _709_转换成小写字母_0728SO {
	public String toLowerCase(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int mun = str.charAt(i);
			if (mun>=65&&mun<=90){
				stringBuilder.append((char)(mun+32));
			} else {
				stringBuilder.append((char)mun);
			}
		}
		String s = stringBuilder.toString();
		return s;
	}
}
