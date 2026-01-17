import java.io.*;

public class Main{
    private static final int OFFSET = 1;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String line = br.readLine();
        int i = Integer.parseInt(br.readLine()) - OFFSET;
        System.out.println(line.charAt(i));
        br.close();
    }
}