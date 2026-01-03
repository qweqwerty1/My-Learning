import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        Solution sol = new Solution();
        List<Boolean> result = sol.kidsWithCandies(candies, extraCandies);

        for(Boolean b : result) {
            System.out.println("결과 값 : "+b);
        }
    }
}

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0 ;
        for (int candy : candies) {
            if (candy > maxCandies) maxCandies = candy;
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}