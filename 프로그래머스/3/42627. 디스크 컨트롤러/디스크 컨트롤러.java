import java.util.*;

class Solution {
    
    static class Request {
        int num;
        int arrive;
        int duration;
        
        public Request(int num, int arrive, int duration) {
            this.num = num;
            this.arrive = arrive;
            this.duration = duration;
        }
    }
    
    public int solution(int[][] jobs) {
        // jobs를 도착 시간 순으로 정렬
        Request[] r = new Request[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            int[] job = jobs[i];
            r[i] = new Request(i, job[0], job[1]);
        }
        Arrays.sort(r, (a, b) -> Integer.compare(a.arrive, b.arrive));
        
        Queue<Request> queue = new LinkedList<>();
        for (Request req : r) {
            queue.offer(req);
        }
        
        PriorityQueue<Request> pq = new PriorityQueue<>(
            Comparator.<Request>comparingInt(req -> req.duration)
            .thenComparingInt(req -> req.arrive)
            .thenComparingInt(req -> req.num)
        );
        
        int time = 0;
        int totalTime = 0;
        while(!queue.isEmpty() || !pq.isEmpty()) {
            // 현재 시간까지 도착한 작업들을 pq에 추가
            while(!queue.isEmpty() && queue.peek().arrive <= time) {
                pq.offer(queue.poll());
            }
            
            if (pq.isEmpty()) {
                // 실행할 작업이 없으면 다음 작업 도착 시간으로 점프
                time = queue.peek().arrive;
            } else {
                // 우선순위가 가장 높은 작업 하나만 처리
                Request curReq = pq.poll();
                totalTime += time + curReq.duration - curReq.arrive;
                time += curReq.duration;
            }
        }
        
        return totalTime / jobs.length;
    }
}