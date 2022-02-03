package programmers.level1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] board={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves={1,5,3,5,1,2,1,4};
        System.out.println(solution.solution(board,moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            Stack<Integer> stack=new Stack<>(); // LIFO
            int answer = 0;

            for(int move:moves){
                for(int i=0;i< board.length;i++){
                    if(board[i][move-1]==0){
                        continue;
                    } else {
                        if(!stack.isEmpty() && stack.peek()==board[i][move-1]){
                            stack.pop();
                            board[i][move-1]=0;
                            answer+=2;
                            break;
                        }
                        stack.add(board[i][move-1]);
                        board[i][move-1]=0;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
