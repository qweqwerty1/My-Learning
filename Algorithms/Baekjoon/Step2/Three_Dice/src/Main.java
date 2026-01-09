import java.util.HashMap;
import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println(Solution.gameResult(x,y,z));
        sc.close();
    }
}

class Solution {
    public static int gameResult(int x, int y, int z){
        HashMap<Integer,Integer> diceHashMap = new HashMap<>();
        int[] diceArray = {x,y,z};
        for(int i : diceArray){
            diceHashMap.put(i,diceHashMap.getOrDefault(i, 0) + 1);
        }
        if(diceHashMap.size() == 1){
            return 10000 + x * 1000;
        }
        if(diceHashMap.size() == 2){
            for (int key : diceHashMap.keySet()) {
                if(diceHashMap.get(key) == 2){
                    return 1000 + key * 100;
                }
            }
        }
        int maxNum = 0;
        for (int key : diceHashMap.keySet()){
            maxNum = Math.max(maxNum, key);
        }
        return maxNum*100;
    }
}
