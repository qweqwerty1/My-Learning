import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (st.countTokens() != N) return;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if(min > n) min = n;
            if(max < n) max = n;
        }
        System.out.println(min + " " + max);
        br.close();
    }
}