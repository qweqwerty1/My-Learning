import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    private static final int convertYear = 2541 - 1998;
    public static void main(String[] args){
        int Year = sc.nextInt();
        System.out.printf("%d",Year - convertYear);
        sc.close();
    }
}