import java.io.*;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i = 0;i < T;i++){
            String line = br.readLine();
            Solution.memorizeHeadAndTail(line, bw);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution{
    public static void memorizeHeadAndTail(String line, final BufferedWriter bw) throws IOException{
        bw.write(line.charAt(0));
        bw.write(line.charAt(line.length() - 1));
        bw.newLine();
    }
}