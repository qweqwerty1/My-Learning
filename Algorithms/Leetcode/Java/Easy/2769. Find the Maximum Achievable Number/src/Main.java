import java.util.Scanner;

class Solution {
    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int t = Integer.parseInt(scanner.nextLine());
        Solution sol = new Solution();
        System.out.println(sol.theMaximumAchievableX(num, t));
    }
}