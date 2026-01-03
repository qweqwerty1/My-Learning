import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] stringNumbers = line.split(" ");

        int [] nums = new int[stringNumbers.length];

        for (int i = 0 ; i < stringNumbers.length; i++) {
            nums[i] = Integer.parseInt(stringNumbers[i]);
        }

        Solution sol = new Solution();
        int[] result = sol.getConcatenation(nums);

        System.out.println(Arrays.toString(result));

        scanner.close();
    }
}