package programmers.level2;

public class 쿼드압축_후_개수_세기 {

    static class Solution {

        static int[] answer=new int[2];

        public int[] solution(int[][] arr) {

            div_conquer(0,0,arr.length,arr);
            return answer;
        }

        public static void div_conquer(int r, int c, int len, int [][] arr){

            boolean checkNum=true;

            Loop:
            for(int i=r;i<r+len;i++){
                for(int j=c;j<c+len;j++){
                    if(arr[r][c]!=arr[i][j]){
                        checkNum=false;
                        break Loop;
                    }
                }
            }

            if(checkNum){
                answer[arr[r][c]]++;
                return;
            }

            div_conquer(r,c,len/2,arr);
            div_conquer(r+len/2,c,len/2,arr);
            div_conquer(r,c+len/2,len/2,arr);
            div_conquer(r+len/2,c+len/2,len/2,arr);

        }

    }
}
