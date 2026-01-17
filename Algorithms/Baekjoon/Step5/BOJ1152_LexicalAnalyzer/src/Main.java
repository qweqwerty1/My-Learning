import java.io.*;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String line = br.readLine();
        int result = Solution.lexicalAnalyzer(line);
        System.out.println(result);
        br.close();
    }
}

class Solution{
    public static int lexicalAnalyzer(String S){
        StringTokenizer st = new StringTokenizer(S);
        return st.countTokens();
    }
}