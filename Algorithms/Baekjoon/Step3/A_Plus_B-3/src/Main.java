import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int T = sc.nextInt();
        for(int i = 0;i < T;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(A+B);
        }
        sc.close();
    }
}