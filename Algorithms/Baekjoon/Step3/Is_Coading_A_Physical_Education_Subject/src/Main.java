import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int N = sc.nextInt();
        System.out.println(Solution.formatLongString(N));
        sc.close();
    }
}

class Solution{
    private static final String TARGET_STRING = "long";
    public static String formatLongString(int count){
        StringBuilder sb = new StringBuilder();
        int n = count/4;

        for(int i = 0;i < n;i++) sb.append(TARGET_STRING).append(" ");
        sb.append("int");

        return sb.toString();
    }
}