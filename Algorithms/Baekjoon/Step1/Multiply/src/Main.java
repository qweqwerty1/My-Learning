import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int A = sc.nextInt();
        int B = sc.nextInt();
        int result = A * B;
        ArrayList<Integer> n = new ArrayList<>();
        while(B > 0) {
            int r = B%10;
            B /= 10;
            n.add(r);
        }

        for(int i : n){
            System.out.printf("%d\n",A*i);
        }
        System.out.printf("%d\n", result);
        sc.close();
    }
}