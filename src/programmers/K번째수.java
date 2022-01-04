package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class K번째수 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int[] array={1,5,2,6,3,7,4};
        int[][] commands={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution.solution(array,commands)));

    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];
            ArrayList<Integer> list[] = new ArrayList[commands.length];

            for(int i=0;i<commands.length;i++){
                list[i]=new ArrayList<>();
            }

            for(int i=0;i<commands.length;i++){
                for(int j=commands[i][0]-1;j<commands[i][1];j++){
                    list[i].add(array[j]);
                }
                // int[] temp=Arrays.copyOfRange(array, command[i][0]-1, command[i][1])로 줄일 수 있다.
                Collections.sort(list[i]);
                answer[i]= list[i].get(commands[i][2] - 1);
            }

            return answer;
        }
    }
}
