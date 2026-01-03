import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args){
        String s = "abc";
        Solution sol = new Solution();
        System.out.printf("result : %d",sol.reverseDegree(s));
    }
}

class Solution {
    public int reverseDegree(String s) {
        return IntStream.range(0, s.length())
                .map(i -> (26 - (s.charAt(i) - 'a')) * (i + 1))
                .sum();
    }
}