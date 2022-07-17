package programmers.level1;

import java.util.*;

public class 두_개_뽑아서_더하기 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int number[]={2,1,3,4,1};
        System.out.println(Arrays.toString(solution.solution(number)));
    }

    static class Solution {
        public int[] solution(int[] numbers) {

            HashSet<Integer> set=new HashSet<>();

            for(int i=0;i<numbers.length;i++){
                for(int j=i+1;j<numbers.length;j++){
                    set.add(numbers[i]+numbers[j]);
                }
            }

            return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
    }
}
