import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final int[] STANDARD_SET = { 1, 1, 2, 2, 2, 8 };
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0;st.hasMoreTokens();i++){
            int input = Integer.parseInt(st.nextToken());
            int diff = STANDARD_SET[i] - input;
            bw.write(diff + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}