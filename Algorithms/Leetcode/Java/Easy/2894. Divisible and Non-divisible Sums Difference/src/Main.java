import java.util.Scanner;

class Solution {
    public int differenceOfSums(int n, int m) {
        int num2 = 0;
        for (int i = m ; i <= n ; i += m) {
            num2 += i;
        }
        int totalNum = n * (n+1) / 2;
        return totalNum - 2 * num2;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        Solution sol = new Solution();
        System.out.println(sol.differenceOfSums(n, m));
        scanner.close();
    }
}