import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.printf("%d\n",A+B);
        System.out.printf("%d\n",A-B);
        System.out.printf("%d\n",A*B);
        System.out.printf("%d\n",A/B);
        System.out.printf("%d\n",A%B);
        sc.close();
    }
}