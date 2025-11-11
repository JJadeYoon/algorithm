class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];
        int maxyw = total;
        for (int i = 1; i < maxyw; i++) {
            int yw = i;
            int yh = yellow / yw;
            if (yh > yw) {
                int temp = yw;
                yw = yw;
                yh = temp;
            }
            if ((yw + 2) * (yh + 2) == total) {
                answer[0] = yw + 2;
                answer[1] = yh + 2;
                break;
            }
        }
        return answer;
    }
}