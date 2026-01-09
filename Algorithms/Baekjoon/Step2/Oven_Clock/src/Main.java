import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int cookingTime = sc.nextInt();
        int[] result = Solution.getTimeConvert(hour, min, cookingTime);
        for(int i : result) {
            System.out.printf("%d ",i);
        }
        sc.close();
    }
}

class Solution{
    public static int[] getTimeConvert(int h, int m, int c){
        int time = h*60 + m;
        int[] result = new int[2];
        time += c;
        if (time >= 24 * 60) {
            time -= 24 * 60;
        }
        result[0] = time/60;
        result[1] = time%60;
        return result;
    }
}