import java.util.Scanner;

class Solution {
    public int scoreOfString(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            result += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Solution sol = new Solution();
        System.out.println(sol.scoreOfString(s));
        scanner.close();
    }
}