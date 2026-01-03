import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double celsius = Double.parseDouble(line);
        Solution sol = new Solution();
        double[] result = sol.convertTemperature(celsius);
        System.out.println(Arrays.toString(result));

        scanner.close();
    }
}