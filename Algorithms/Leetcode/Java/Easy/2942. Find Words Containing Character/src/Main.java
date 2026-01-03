import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            if (word.indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("단어들을 공백으로 구분해서 입력하세요:");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        System.out.println("포함될 단어를 입력하세요 :");
        char x = scanner.nextLine().charAt(0);
        Solution sol = new Solution();
        System.out.println(sol.findWordsContaining(words, x));
        scanner.close();
    }
}