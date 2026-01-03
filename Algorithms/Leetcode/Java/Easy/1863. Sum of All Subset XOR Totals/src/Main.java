import java.util.Scanner;

class Solution {
    private int totalSum;

    public int subsetXORSum(int[] nums) {
        this.totalSum = 0;
        dfs(nums, 0, 0);
        return this.totalSum;
    }

    private void dfs(int[] nums,int index,int currentXor) {
        if (index == nums.length) {
            this.totalSum += currentXor;
            return;
        }

        dfs(nums, index + 1, currentXor ^ nums[index]);
        dfs(nums, index + 1, currentXor);
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] stringNumber = line.split(" ");

        int[] nums = new int[stringNumber.length];

        for (int i = 0; i < stringNumber.length; i++) {
            nums[i] = Integer.parseInt(stringNumber[i]);
        }

        Solution sol = new Solution();
        System.out.println(sol.subsetXORSum(nums));

        scanner.close();
    }
}