import java.util.Scanner;

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.defangIPaddr(address));

        scanner.close();
    }
}