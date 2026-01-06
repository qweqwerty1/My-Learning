import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        System.out.printf("%d\n",(A+B)%C);
        System.out.printf("%d\n",((A%C)+(B%C))%C);
        System.out.printf("%d\n",(A*B)%C);
        System.out.printf("%d\n",((A%C)*(B%C))%C);
        sc.close();
    }
}