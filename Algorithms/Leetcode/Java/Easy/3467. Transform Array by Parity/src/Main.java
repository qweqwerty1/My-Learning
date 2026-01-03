import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("배열의 크기를 입력하세요 : ");
        int numsSize = sc.nextInt();
        int[] nums = new int[numsSize];
        for(int i = 0;i < nums.length;i++) {
            System.out.printf("%d번째 원소의 수 : ",i);
            nums[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.print("결과 값(배열) : ");
        for(int i : sol.transformArray(nums)) {
            System.out.printf("%d ",i);
        }
    }
}

class Solution {
    public int[] transformArray(int[] nums) {
        int evenNums = 0, oddNums = 0;
        for(int i : nums) {
            if(i%2 == 0) evenNums++;
            else oddNums++;
        }
        int[] result = new int[nums.length];
        for(int i = evenNums;i < nums.length;i++){
            result[i] = 1;
        }
        return result;
    }
}