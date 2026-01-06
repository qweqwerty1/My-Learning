import java.util.Scanner;

public class Main{
    private final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int score = sc.nextInt();
        System.out.println(GradeChecker.getGrade(score));
        sc.close();
    }
}

class GradeChecker{
    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }
}