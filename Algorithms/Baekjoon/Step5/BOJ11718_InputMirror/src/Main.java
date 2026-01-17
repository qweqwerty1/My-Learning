import java.io.*;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String line;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}