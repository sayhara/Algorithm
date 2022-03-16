package programmers.level2;

public class 삼각_달팽이 {

    class Solution {
        public int[] solution(int n) {
            int[] answer = new int[n*(n+1)/2];
            int arr[][]=new int[n][n];
            int num=1;
            int r=-1, c=0;

            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    if(i%3==0){
                        r++; // 아래로만 이동
                    }
                    else if(i%3==1){
                        c++; // 오른쪽으로 이동
                    }
                    else if(i%3==2){
                        r--; // 대각선으로 이동
                        c--;
                    }
                    arr[r][c]=num++;
                }
            }

            int idx=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]!=0){
                        answer[idx++]=arr[i][j];
                    }
                }
            }

            return answer;
        }
    }
}
