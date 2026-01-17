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
        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() != 3) return;
            Solution.assignBalls(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), result);
        }
        Solution.getFinalBasketState(result, bw);
        bw.flush();
        bw.close();
        br.close();

    }
}

class Solution{
    public static void assignBalls(final int start, final int end, final int number, int[] array){
        for(int i = start - 1;i < end;i++){
            array[i] = number;
        }
    }
    public static void getFinalBasketState(int[] result, BufferedWriter bw) throws IOException{
        for(int i : result){
            bw.write(i + " ");
        }
    }
}