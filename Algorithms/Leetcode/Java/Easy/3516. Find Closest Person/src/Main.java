import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Person 1(x) Value : ");
        int x = sc.nextInt();
        System.out.print("Person 2(y) value : ");
        int y = sc.nextInt();
        System.out.print("Person 3(z) value : ");
        int z = sc.nextInt();

        Solution sol = new Solution();

        System.out.printf("결과 값 : %d",sol.findClosest(x,y,z));

        sc.close();
    }
}

class Solution {
    public int findClosest(int x, int y, int z) {
        int p1 = Math.abs(x - z);
        int p2 = Math.abs(y - z);
        if ((p1-p2) != 0) return p1<p2 ? 1 : 2;
        else return 0;
    }
}