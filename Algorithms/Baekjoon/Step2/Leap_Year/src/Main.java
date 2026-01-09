import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int year = sc.nextInt();
        if(Solution.isLeapYear(year)) System.out.println(1);
        else System.out.println(0);
        sc.close();
    }
}

class Solution{
    public static boolean isLeapYear(int year){
        return (year%4 == 0 && year%100 != 0) || year%400 == 0;
    }
}