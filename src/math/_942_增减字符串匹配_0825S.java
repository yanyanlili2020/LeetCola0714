package math;

/**
 *
 */
public class _942_增减字符串匹配_0825S {
    public int[] diStringMatch(String S) {
        int[] a = new int[S.length() + 1];
        int i = 0;
        int low = 0;
        int high = S.length();
        for(char c : S.toCharArray()) {
            if(c == 'I') {
                a[i++] = low++;
            }
            else if(c == 'D') {
                a[i++] = high--;
            }
        }
//            慢1ms
//            for(int i = 0; i < N; ++i) {
//                if(S.charAt(i) == 'I')
//                    ans[i] = low++;
//                else
//                    ans[i] = high--;
//            }
        a[S.length()] = low;
        return a;
    }
}

    
