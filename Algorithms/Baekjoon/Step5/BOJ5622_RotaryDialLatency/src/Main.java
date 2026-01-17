import java.io.*;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String line = br.readLine();
        int result = Solution.stringToSeconds(line);
        System.out.println(result);
        br.close();
    }
}

class Solution {
    private static final int[] TIME_TABLE = {
            3, 3, 3,
            4, 4, 4,
            5, 5, 5,
            6, 6, 6,
            7, 7, 7,
            8, 8, 8, 8,
            9, 9, 9,
            10, 10, 10, 10
    };
    public static int stringToSeconds(String line){
        int n = line.length();
        int result = 0;
        for(int i = 0;i < n;i++){
            result += TIME_TABLE[line.charAt(i) - 'A'];
        }
        return result;
    }
}