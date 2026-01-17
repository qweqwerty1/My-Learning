import java.io.*;

public class Main{
    private static final int TOTAL_STUDENT = 30;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        boolean[] result = new boolean[TOTAL_STUDENT + 1];
        result[0] = true;

        Solution.markAsSubmitted(result, br);
        Solution.identifyAbsentees(result, bw);

        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution{
    private static final int SUBMITTED_COUNT = 28;
    public static void markAsSubmitted(boolean[] array, BufferedReader br) throws IOException{
        for(int i = 1; i < SUBMITTED_COUNT + 1; i++){
            int n = Integer.parseInt(br.readLine());
            array[n] = true;
        }
    }
    public static void identifyAbsentees(boolean[] array, BufferedWriter bw) throws IOException{
        for(int i = 0;i < array.length;i++){
            if(!array[i]) bw.write(i + "\n");
        }
    }
}