package programmers.level2;

import java.util.Arrays;

public class 행렬_테두리_회전하기 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int rows=6;
        int cols=6;
        int[][] query={{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution.solution(rows,cols,query)));

    }

    static class Solution {

        static int arr[][];
        static int row,col;

        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            arr=new int[rows][columns];
            row=rows; col=columns;
            int cnt=1;

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    arr[i][j]=cnt++;
                }
            }

            for(int i=0;i<queries.length;i++){
                answer[i]=rotate(queries[i]);
            }

            return answer;
        }

        public static int rotate(int[] query){

            int r1=query[0]-1; int c1=query[1]-1;
            int r2=query[2]-1; int c2=query[3]-1;

            int copy[][]=new int[row][col];
            int temp=arr[r1][c1];
            int min=temp;

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    copy[i][j]=arr[i][j]; // 값 복사
                }
            }

            // 왼쪽 -> 오른쪽
            for(int i=c2;i>c1;i--){
                arr[r1][i]=copy[r1][i-1]; // 다음 열로 복사
                min=Math.min(min,arr[r1][i]);
            }

            // 오른쪽 -> 아래쪽
            for(int i=r2;i>r1;i--){
                arr[i][c2]=copy[i-1][c2]; // 다음 행으로 복사
                min=Math.min(min,arr[i][c2]);
            }

            // 오른쪽 -> 왼쪽
            for(int i=c1;i<c2;i++){
                arr[r2][i]=copy[r2][i+1]; // 이전 열로 복사
                min=Math.min(min,arr[r2][i]);
            }

            // 아래쪽 -> 위쪽
            for(int i=r1;i<r2;i++){
                arr[i][c1]=copy[i+1][c1]; // 이전 행으로 복사
                min=Math.min(min,arr[i][c1]);
            }
            return min;
        }
    }
}
