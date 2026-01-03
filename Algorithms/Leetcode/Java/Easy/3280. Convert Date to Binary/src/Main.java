public class Main{
    public static void main(String[] args){
        String date = "1994-01-04";
        Solution sol = new Solution();
        System.out.printf("%s",sol.convertDateToBinary(date));
    }
}

class Solution {
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");

        String yearBin = Integer.toBinaryString(Integer.parseInt(parts[0]));
        String monthBin = Integer.toBinaryString(Integer.parseInt(parts[1]));
        String dayBin = Integer.toBinaryString(Integer.parseInt(parts[2]));

        return String.join("-", yearBin, monthBin, dayBin);
    }
}