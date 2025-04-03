class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        // 최대 이동 횟수 (왼쪽에서 오른쪽으로 쭉 이동)
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            // 상하 이동 계산
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // i는 꺾는 위치
            // 다음 위치부터 연속된 A가 끝나는 지점 찾기
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            move = Math.min(move, i * 2 + (length - nextIndex)); // 뒤로 갔다가 처음부터 남은 거리
            move = Math.min(move, (length - nextIndex) * 2 + i); // 남은 거리 먼저 갔다가 처음부터 현재 위치까지
        }

        return answer + move;
    }
}