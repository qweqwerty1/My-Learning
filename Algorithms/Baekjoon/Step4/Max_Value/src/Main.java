import java.io.*;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 1;
        for(int i = 1;i < 10;i++){
            int n = Integer.parseInt(br.readLine());
            if(maxValue < n){
                maxValue = n;
                maxIndex = i;
            }
        }
        System.out.println(maxValue + " " + maxIndex);
        br.close();
    }
}