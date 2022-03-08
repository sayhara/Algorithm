package programmers.level3;

import java.util.*;

public class 디스크_컨트롤러 {

    class Solution {
        public int solution(int[][] jobs) {
            int answer=0;
            int jobsIdx=0;
            int end=0;
            int count=0;

            // 요청시간 오름차순으로 정렬
            Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);
            // 처리시간 오름차순으로 정렬
            PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);

            while(count<jobs.length){
                while(jobsIdx<jobs.length && jobs[jobsIdx][0]<=end){ // 작업 수행 가능하면
                    pq.add(jobs[jobsIdx++]);
                }

                if(pq.isEmpty()){
                    end=jobs[jobsIdx][0];
                } else {
                    int[] temp=pq.poll();
                    answer+=end+temp[1]-temp[0];
                    end+=temp[1];
                    count++;
                }
            }


            return (int)Math.floor(answer/jobs.length);
        }
    }
}
