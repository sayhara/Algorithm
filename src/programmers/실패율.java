package programmers;

import java.util.*;

public class 실패율 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int N=5;
        int[] stages={4,4,4,4,4};
        System.out.println(Arrays.toString(solution.solution(N,stages)));
    }

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            int[] count=new int[N];
            double[][] fail=new double[N][2];
            int len=stages.length;

            for(int i=0;i<N;i++){
                for(int j=0;j<stages.length;j++){
                    if(stages[j]==i+1){
                        count[i]++;
                    }
                }
                if(count[i]==0){
                    fail[i][1]=i+1;
                    continue;
                }

                fail[i][0]=(double) count[i]/len;
                fail[i][1]=i+1;
                len-=count[i];
            }

            Arrays.sort(fail, new Comparator<double[]>() {

                @Override
                public int compare(double[] o1, double[] o2) {
                    if(o1[0]>o2[0]){
                        return -1; // 음수->오름차순
                    } else if(o1[0]==o2[0]){
                        return Double.valueOf(o1[1]).compareTo(Double.valueOf(o2[1]));
                    } else {
                        return 1; // 양수->내림차순
                    }
                }
            });

            for(int i=0;i<N;i++){
                answer[i]=(int)fail[i][1];
            }


            return answer;
        }
    }
}
