package review;

import java.util.*;

public class 다리를_지나는_트럭 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int bridge_length = 2;
        int weight = 10;
        int truck_weights[] = {7, 4, 5, 6};
        System.out.println(solution.solution(bridge_length, weight, truck_weights));

    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {

            Queue<Integer> q=new LinkedList<>();
            int answer = 0;
            int sum=0;

            for(int i=0;i<truck_weights.length;i++){

                while (true) {
                    if (q.isEmpty()) {
                        q.add(truck_weights[i]);
                        sum += truck_weights[i];
                        answer++;
                        break;
                    } else if (q.size() == bridge_length) {
                        sum-=q.poll();
                    } else {
                        if (truck_weights[i] + sum <= weight) {
                            q.add(truck_weights[i]);
                            sum += truck_weights[i];
                            answer++;
                            break;
                        } else {
                            // 무게가 초과하면 큐에 0을 q.size() == bridge_length에 걸려 맨 앞의 값이 지나가도록 설정
                            q.add(0);
                            answer++;
                        }
                    }
                }
            }

            return answer+bridge_length;
        }
    }
}
