import java.io.*;
import java.util.Arrays;

public class Main{
    private final static int END_OF_FILE = -1;
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int[] alphaTable = new int[26];

        Arrays.fill(alphaTable,-1);

        for(int i = 0;true;i++){
            int c = br.read();
            if(c == END_OF_FILE || c == '\n') break;
            Solution.fillTable(alphaTable,c,i);
        }

        Solution.saveOutput(alphaTable, bw);
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution{
    public static void fillTable(int[] table, int c, int i){
        int index = c - 'a';

        if (table[index] == -1) {
            table[index] = i;
        }
    }
    public static void saveOutput(int[] table, BufferedWriter bw) throws IOException{
        for(int i : table){
            bw.write(i + " ");
        }
    }
}