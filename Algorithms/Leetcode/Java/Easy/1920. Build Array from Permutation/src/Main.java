import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0 ; i < n ; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0 ; i < n ; i++) {
            nums[i] = nums[i] / n;
        }
        return nums;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] stringNumbers = line.split(" ");

        int[] nums = new int[stringNumbers.length];

        for (int i = 0 ; i < stringNumbers.length ; i++) {
            nums[i] = Integer.parseInt(stringNumbers[i]);
        }

        Solution sol = new Solution();
        int[] ans = sol.buildArray(nums);

        System.out.println(Arrays.toString(ans));

        scanner.close();
    }
}