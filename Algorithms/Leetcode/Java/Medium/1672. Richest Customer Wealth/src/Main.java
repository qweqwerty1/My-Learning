import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("전체 행의 개수 입력 : ");
        int accountsSize = sc.nextInt();
        System.out.print("재산(은행)의 갯수 입력 : ");
        int accountsColSize = sc.nextInt();
        int[][] accounts = new int[accountsSize][accountsColSize];
        for(int i = 0;i < accountsSize;i++){
            System.out.printf("%d번째 사람의 재산 입력\n",i);
            for(int j = 0;j < accountsColSize;j++){
                System.out.printf("%d번 은행 재산 : ",j);
                accounts[i][j] = sc.nextInt();
            }
        }
        Solution sol = new Solution();
        int result = sol.maximumWealth(accounts);
        System.out.printf("가장 부유한 사람의 재산 : %d",result);

        sc.close();
    }
}

class Solution {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(Array -> Arrays.stream(Array).sum())
                .max()
                .getAsInt();
    }
}