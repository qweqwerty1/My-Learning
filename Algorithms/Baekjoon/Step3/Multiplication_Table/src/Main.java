import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int num = sc.nextInt();
        Solution.getTimesTable(num);
        sc.close();
    }
}

class Solution{
    public static void getTimesTable(int num){
        for(int i = 1;i < 10;i++) {
            System.out.printf("%d * %d = %d\n", num, i, num * i);
        }
    }
}