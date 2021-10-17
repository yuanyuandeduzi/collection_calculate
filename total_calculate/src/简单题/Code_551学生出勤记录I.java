package 简单题;

public class Code_551学生出勤记录I {
    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int n = 0, m = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'A') {
                n++;
            }else if(arr[i] == 'L') {
                m++;
            }else {
                m = 0;
            }
            if(n == 2 || m == 3) {
                return false;
            }
        }
        return true;
    }
}
