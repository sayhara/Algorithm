package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
https://minhamina.tistory.com/241
 */

public class 다리를_지나는_트럭 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int truck_weights[] = {7, 4, 5, 6};
        System.out.println(solution.solution(bridge_length, weight, truck_weights));

    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> q = new LinkedList<>(); // FIFO
            int answer = 0;
            int sum = 0;

            for (int truck : truck_weights) {
                while (true) {
                    if (q.isEmpty()) {
                        q.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    } else if (q.size() == bridge_length) {
                        sum -= q.poll();
                    } else {
                        if (sum + truck > weight) {
                            q.add(0);
                            answer++;
                        } else {
                            q.add(truck);
                            sum += truck;
                            answer++;
                            break;
                        }
                    }
                }
            }

            return answer + bridge_length;
        }
    }
}
