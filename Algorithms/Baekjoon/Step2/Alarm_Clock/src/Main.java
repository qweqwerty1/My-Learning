import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int[] result = Solution.getTimeConvert(hour, min);
        for(int i : result) {
            System.out.printf("%d ",i);
        }
        sc.close();
    }
}

class Solution{
    public static int[] getTimeConvert(int h, int m){
        int time = h*60 + m;
        int[] result = new int[2];
        time -= 45;
        if (time < 0) {
            time += 24 * 60;
        }
        result[0] = time/60;
        result[1] = time%60;
        return result;
    }
}