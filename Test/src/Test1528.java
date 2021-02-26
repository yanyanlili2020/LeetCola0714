/**
 *
 */
public class Test1528 {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        char[] result = new char[s.length()];
        int i = 0;
        for(char c : s.toCharArray()) {
            
            result[indices[i++]] = c;
        }
        
    }
}
