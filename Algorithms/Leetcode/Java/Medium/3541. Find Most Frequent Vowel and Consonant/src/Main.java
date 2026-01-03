import java.util.*;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("빈도 수 측정 문자열 입력 : ");
        String s = sc.nextLine();
        Solution sol = new Solution();
        System.out.printf("결과 값 : %d\n",sol.maxFreqSum(s));
    }
}

/*
class Solution {
    public int maxFreqSum(String s) {
        Map<Character,Integer> countMap = new HashMap<>();

        for(char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        Set<Character> vowels = Set.of('a','e','i','o','u');

        int maxVowel = 0;
        int maxConsonant = 0;

        for(char key : countMap.keySet()) {
            int freq = countMap.get(key);

            if(vowels.contains(key)) {
                maxVowel = Math.max(maxVowel,freq);
            }
            else {
                maxConsonant = Math.max(maxConsonant, freq);
            }
        }

        return maxVowel + maxConsonant;
    }
}
*/

class Solution {
    public int maxFreqSum(String s) {
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        String vowels = "aeiou";

        for (int i = 0;i < 26; i++) {
            char currentChar = (char)('a'+ i);
            int freq = counts[i];

            if (freq == 0) continue;

            if (vowels.indexOf(currentChar) >= 0) {
                maxVowel = Math.max(maxVowel,freq);
            }
            else {
                maxConsonant = Math.max(maxConsonant,freq);
            }
        }
    return maxConsonant + maxVowel;
    }
}
