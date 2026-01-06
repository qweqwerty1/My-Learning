import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        double A = sc.nextDouble();
        double B = sc.nextDouble();
        System.out.printf("%.10f",A/B);
        sc.close();
    }
}