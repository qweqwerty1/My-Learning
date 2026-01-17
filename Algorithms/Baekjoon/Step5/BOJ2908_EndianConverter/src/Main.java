import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Solution.invert(Integer.parseInt(st.nextToken()));
        int B = Solution.invert(Integer.parseInt(st.nextToken()));
        System.out.println(Math.max(A, B));
        br.close();
    }
}

class Solution{
    public static int invert(int n){
        int hundreds = n / 100;
        int tens = (n / 10) % 10;
        int ones = n % 10;

        return (ones * 100) + (tens * 10) + hundreds;
    }
}