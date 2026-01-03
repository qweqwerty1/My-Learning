public class Main{
    public static void main(String[] argh){
        int[] nums = {1,2,3,1,1,3};
        Solution sol = new Solution();
        int result = sol.numIdenticalPairs(nums);
        System.out.printf("%d",result);
    }
}

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int[] count = new int[101];
        for (int num : nums) {
            result += count[num]++;
        }
        return result;
    }
}