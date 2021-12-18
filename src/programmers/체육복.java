package programmers;

import java.util.Arrays;

/*
생각보다 고려해야 할 사항이 많았다.
간과했던 사항으로 우선 분실한 사람과 여벌 체육복을 가져온 사람이 같다면
우선적으로 자신이 착용을 해야하므로 이를 먼저 선별하는 과정이 필요하다.
예를 들어, n=3, lost[]={1,2}, reserve={2,3}의 경우
정답은 3이 아닌 2가 된다.
두번째로 정렬의 과정이 필요한데 주어지는 배열은 차순이 정렬이 된 경우가 아니므로
예를 들어, n=5, lost[]={4,2}, reserve={3,5}의 경우
4번이 3한테 빌리게 된다면 2는 5번한테 빌릴 수가 없게 되어 4가 답이 된다.
그러나 만약 2번이 3한테 빌리고, 4번이 5한테 빌린다면 최대 5의 결과가 나타날 수 있다.
따라서, 정렬을 통해 두 차등으로 배급하도록 하는 과정이 필요하다.
 */

public class 체육복 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int n=4;
        int[] lost={3,1,2};
        int[] reserve={2,4,3};
        System.out.println(solution.solution(n,lost,reserve));

    }

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n-lost.length;
            int count=0;

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i=0;i<lost.length;i++){
                for(int j=0;j<reserve.length;j++){

                    if(lost[i]==reserve[j]){
                        count++;
                        lost[i]=-1;
                        reserve[j]=-1;
                        break;
                    }
                }
            }

            for(int i=0;i<lost.length;i++){
                for(int j=0;j<reserve.length;j++){

                    if(lost[i]-1==reserve[j] || lost[i]+1==reserve[j]){
                        count++;
                        lost[i]=-1;
                        reserve[j]=-1;
                        break;
                    }
                }
            }
            answer+=count;

            return answer;
        }
    }
}