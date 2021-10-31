package 数组;

public class Code_392判断子序列 {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        int n = 0;
        for(int i = 0; i < t.length(); i++) {
            if(s.charAt(n) == t.charAt(i)) {
                n++;
            }
            if(n == s.length()) {
                return true;
            }
        }
        return false;
    }
}
