import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (st.countTokens() != 2) return;
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        if (st.countTokens() != N) return;
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if(n < X) {
                bw.write( n + " " );
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}