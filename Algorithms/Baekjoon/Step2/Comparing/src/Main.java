import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int A = sc.nextInt();
        int B = sc.nextInt();
        NumberComparator.printComparison(A,B);
        sc.close();
    }
}

class NumberComparator {
    public static void printComparison(int num1, int num2){
        if(num1 == num2) {
            System.out.println("==");
            return;
        }
        System.out.println((num1 > num2) ? ">":"<");
    }
}