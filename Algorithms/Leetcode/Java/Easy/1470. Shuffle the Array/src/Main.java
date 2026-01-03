import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("배열의 크기를 정하시오 : ");
        int n = sc.nextInt()/2;
        int[] nums = new int[n*2];
        for(int i = 0;i < nums.length;i++){
            System.out.printf("%d번째 원소의 값 : ",i);
            nums[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        int[] result = sol.shuffle(nums,n);
        System.out.println("결과 값 : " + Arrays.toString(result));
        sc.close();
    }
}

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n*2];
        for(int i = 0;i < nums.length;i++){
            if(i%2 == 0){
                result[i] = nums[i/2];
            }
            else {
                result[i] = nums[(i/2) + n];
            }
        }
        return result;
    }
}