public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3};
        int k = 4;
        Solution result = new Solution();
        System.out.println(result.minOperations(nums, k));
    }
}

class Solution {
    public int minOperations(int[] nums, int k) {
        int SumNums = 0;
        for (int num : nums) {
            SumNums += num;
        }
        return SumNums % k;
    }
}