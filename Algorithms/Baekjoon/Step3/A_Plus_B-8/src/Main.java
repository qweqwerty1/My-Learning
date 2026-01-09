import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        if (line == null) return;

        int T = Integer.parseInt(line);

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Solution.addResult(i, A, B, bw);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {
    public static void addResult(int c, int a, int b, BufferedWriter bw) throws IOException {
        bw.write("Case #");
        bw.write(String.valueOf(c + 1));
        bw.write(": ");
        bw.write(String.valueOf(a));
        bw.write(" + ");
        bw.write(String.valueOf(b));
        bw.write(" = ");
        bw.write(String.valueOf(a + b));
        bw.newLine();
    }
}