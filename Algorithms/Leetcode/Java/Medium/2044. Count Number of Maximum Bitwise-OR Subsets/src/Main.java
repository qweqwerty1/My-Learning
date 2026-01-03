import java.util.*;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("배열의 크기를 설정하세요 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < nums.length;i++) {
            System.out.printf("%d번째 원소 입력 : ",i);
            nums[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.print("결과 값 : ");
        System.out.println(sol.countMaxOrSubsets(nums));

        sc.close();
    }
}

class Solution {
    int countMaxOrSubsets(int[] nums) {
        int k = 0;
        for (int i : nums) {
            k |= i;
        }
        int idx = 0, currentNum = 0;
        return DFS(nums,k,idx,currentNum);
    }

    int DFS(int[] nums, int k, int idx, int currentNum) {
        if (idx == nums.length) {
            return (currentNum == k) ? 1:0;
        }

        int include = DFS(nums,k,idx + 1,currentNum|nums[idx]);
        int exclude = DFS(nums,k,idx + 1,currentNum);

        return include + exclude;
    }
}