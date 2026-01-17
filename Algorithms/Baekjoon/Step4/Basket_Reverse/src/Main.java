import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final int INPUT_TOKEN_COUNT = 2;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(st.countTokens() != INPUT_TOKEN_COUNT) return;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] baskets = new int[N];

        Solution.initializeBaskets(baskets);

        for(int i = 0;i < M;i++){
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() != INPUT_TOKEN_COUNT) return;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Solution.reverseRange(x,y,baskets);
        }

        Solution.buildStatusReport(baskets,bw);
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution{
    private static final int INDEX_OFFSET = 1;
    private static final String DELIMITER = " ";

    public static void initializeBaskets(int[] baskets){
        for(int i = 0;i < baskets.length;i++){
            baskets[i] = i + INDEX_OFFSET;
        }
    }
    public static void reverseRange(int start, int end, int[] baskets){
        start -= INDEX_OFFSET;
        end -= INDEX_OFFSET;
        while(start < end){
            int temp = baskets[start];
            baskets[start++] = baskets[end];
            baskets[end--] = temp;
        }
    }
    public static void buildStatusReport(int[] baskets, BufferedWriter bw) throws IOException {
        for(int i : baskets){
            bw.write(i + DELIMITER);
        }
    }
}