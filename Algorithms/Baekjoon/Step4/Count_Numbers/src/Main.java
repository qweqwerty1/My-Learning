import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(st.countTokens() != N) return;
        int targetNum = Integer.parseInt(br.readLine());
        int result = 0;
        while(st.hasMoreTokens()){
            if(Integer.parseInt(st.nextToken()) == targetNum) result++;
        }
        System.out.println(result);
    }
}