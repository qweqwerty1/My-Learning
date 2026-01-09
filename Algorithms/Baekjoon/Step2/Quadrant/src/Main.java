import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(Quadrant.getQuadrant(x,y));
        sc.close();
    }
}

class Quadrant {
    public static int getQuadrant(int x, int y){
        if(x>0 && y>0) return 1;
        if(x<0 && y>0) return 2;
        if(x<0 && y<0) return 3;
        return 4;
    }
}