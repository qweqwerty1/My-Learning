import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        Solution.drawTriangle(N, bw);
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution{
    public static void drawTriangle(int rows, BufferedWriter bw) throws IOException{
        String allSpaces = " ".repeat(rows);
        String allStars = "*".repeat(rows);
        for(int i = 0;i < rows;i++){
            bw.write(allSpaces, 0, rows - i - 1);
            bw.write(allStars, 0, i + 1);
            bw.newLine();
        }
    }
}