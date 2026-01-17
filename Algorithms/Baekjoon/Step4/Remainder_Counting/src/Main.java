import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class Main{
    private static final int INPUT_LIMIT = 10;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        for(int i = 0;i < INPUT_LIMIT;i++){
            String line = br.readLine();
            if(line == null) return;
            int n = Integer.parseInt(line);
            Solution.addRemainder(n);
        }

        Solution.displayUniqueRemainderCount();
        br.close();
    }
}

class Solution{
    private static final int MODULO_DIVISOR = 42;
    private static final Set<Integer> remainCount = new HashSet<>();
    public static void addRemainder(int value){
        remainCount.add(value%MODULO_DIVISOR);
    }
    public static void displayUniqueRemainderCount(){
        System.out.println(remainCount.size());
    }
}