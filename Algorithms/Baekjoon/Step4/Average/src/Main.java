import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String line = br.readLine();
        if(line == null) return;
        int N = Integer.parseInt(line);
        int[] reportCard = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(st.countTokens() != N) return;
        for(int i = 0;i < reportCard.length;i++){
            reportCard[i] = Integer.parseInt(st.nextToken());
        }
        int max = Solution.findMaxScore(reportCard);
        System.out.println(Solution.calculateNormalizedAverage(reportCard, max));
        br.close();
    }
}

class Solution{
    private static final int NORMALIZATION_FACTOR = 100;
    public static int findMaxScore(int[] scores){
        int max = 0;
        for(int score : scores){
            if(max < score) max = score;
        }
        return max;
    }
    public static double calculateNormalizedAverage(int[] scores, int max){
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (sum / max * NORMALIZATION_FACTOR) / scores.length;
    }
}