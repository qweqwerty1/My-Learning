import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] argd) {
        System.out.print("배열의 크기를 정하세요. : ");
        int numsSize = sc.nextInt();
        int[] nums = new int[numsSize];
        for(int i = 0;i < nums.length;i++){
            System.out.printf("%d번째 원소의 값 : ",i);
            nums[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        int result = sol.alternatingSum(nums);
        System.out.printf("결과 값 : %d",result);

        sc.close();
    }
}

class Solution {
    public int alternatingSum(int[] nums) {
        int result = 0;
        for(int i = 0;i < nums.length;i++){
            if(i%2 == 0) result += nums[i];
            else result -= nums[i];
        }
        return result;
    }
}