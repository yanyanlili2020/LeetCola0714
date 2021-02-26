/**
 *
 */
public class Test387 {
    public static void main(String[] args) {
        String s="loveleetcode";
    
        for(int i=0;i<s.length();i++){
            int cnt=0;
            for(int j=1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    cnt++;}
            
            }
            if(cnt==0)
                System.out.println(i);
        }
        System.out.println(-1);
       
    }
}
