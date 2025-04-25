class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int min, max;
        min = max = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            int n = Integer.parseInt(numbers[i]);
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }
        return min + " " + max;
    }
}