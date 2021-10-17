package 简单题;

import java.time.LocalDate;

public class afg{
    public static void main(String[] args) {

    }

    public int[] reverse(int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        while(left < right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
        return arr;
    }
}
