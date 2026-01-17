import java.io.*;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i = 0;i < N;i++){
            int n = br.read();
            Solution.sumAll(n);
        }
        System.out.println(Solution.getSumNum());
        br.close();
    }
}

class Solution{
    private static int sumNum = 0;
    public static void sumAll(int n){
        sumNum += n - '0';
    }
    public static int getSumNum(){
        return sumNum;
    }
}