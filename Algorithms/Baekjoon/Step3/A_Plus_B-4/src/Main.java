import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String input;
        while ((input = br.readLine()) != null) {
            try {
                StringTokenizer st = new StringTokenizer(input);
                if (!st.hasMoreTokens()) continue;

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                bw.write(String.valueOf(A+B));
                bw.newLine();
            } catch (NoSuchElementException | NumberFormatException e) {
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}