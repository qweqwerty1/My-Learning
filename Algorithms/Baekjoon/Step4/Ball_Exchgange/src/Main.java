import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(st.countTokens() != 2) return;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] result = new int[N];

        Solution.initializeBaskets(result);

        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Solution.swapBalls(x,y,result);
        }

        Solution.buildBasketReport(result,bw);

        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution{
    public static void initializeBaskets(int[] array){
        for(int i = 0;i < array.length;i++){
            array[i] = i + 1;
        }
    }
    public static void swapBalls(int i, int j, int[] array){
        int temp = array[i-1];
        array[i-1] = array[j-1];
        array[j-1] = temp;
    }
    public static void buildBasketReport(int[] array,BufferedWriter bw) throws IOException{
        for(int i : array){
            bw.write(i + " ");
        }
    }
}