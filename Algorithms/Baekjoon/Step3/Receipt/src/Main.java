import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int targetCost = sc.nextInt();
        Solution sol = new Solution(targetCost);
        int N = sc.nextInt();
        for(int i = 0;i < N;i++){
            int price = sc.nextInt();
            int count = sc.nextInt();
            sol.add(price, count);
        }
        if(sol.isVerified()) System.out.println("Yes");
        else System.out.println("No");
    }
}

class Solution{
    private final int targetCost;
    private int currentSum;

    public Solution(int targetCost){
        this.targetCost = targetCost;
    }

    public void add(int price, int count){
        this.currentSum += price * count;
    }

    public boolean isVerified(){
        return targetCost == currentSum;
    }
}