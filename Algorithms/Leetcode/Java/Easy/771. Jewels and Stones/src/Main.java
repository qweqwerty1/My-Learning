import java.util.*;

class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("돌(Stone) 입력 : ");
        String stones = sc.nextLine();
        System.out.print("보석(jewel) 입력 : ");
        String jewels = sc.nextLine();

        Solution sol = new Solution();
        int result = sol.numJewelsInStones(jewels, stones);
        System.out.printf("결과 값은 : %d",result);

        sc.close();
    }
}

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>(jewels.length());

        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }

        int count = 0;

        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }

        return count;
    }
}