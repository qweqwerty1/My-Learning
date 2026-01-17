import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i = 0;i < T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            Solution.inflate(R, S, bw);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution{
    public static void inflate(int R, String S, BufferedWriter bw) throws IOException{
        int n = S.length();
        for(int i = 0;i < n;i++){
            char c = S.charAt(i);
            for(int j = 0;j < R;j++){
                bw.write(c);
            }
        }
        bw.newLine();
    }
}