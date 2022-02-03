package programmers.level3;

import java.util.*;

public class 여행경로 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution.solution(tickets)));
    }

    static class Solution {

        static ArrayList<String> list;
        static boolean visited[];

        public String[] solution(String[][] tickets) {

            list=new ArrayList<>();
            visited=new boolean[tickets.length];
            int cnt=0;
            dfs("ICN","ICN", tickets, cnt);
            Collections.sort(list); // 탐색 중 알파벳

            String[] answer = list.get(0).split(" ");

            return answer;
        }

        public static void dfs(String present, String result, String[][] tickets, int cnt){

            if(cnt==tickets.length){
                list.add(result);
                return;
            }

            for(int i=0;i<tickets.length;i++){
                if(visited[i]==false && tickets[i][0].equals(present)){
                    visited[i]=true;
                    dfs(tickets[i][1], result+" "+tickets[i][1], tickets, cnt+1);
                    visited[i]=false;
                }
            }
            return;
        }
    }
}
