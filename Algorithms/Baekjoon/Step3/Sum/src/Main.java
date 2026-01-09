import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        Solution.getSumNum1(n);
        sc.close();
    }
}

class Solution{
    public static void getSumNum1(int n){
        System.out.printf("%d",n*(n+1)/2);
    }
    public static void getSumNum2(int n){
        int result = 0;
        for(int i = 1;i <= n;i++){
            result += i;
        }
        System.out.println(result);
    }
}