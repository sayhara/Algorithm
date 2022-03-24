package programmers.level2;

import java.util.*;

public class 거리두기_확인하기 {

    static class Solution {

        static int dr[]={-1,0,1,0};
        static int dc[]={0,1,0,-1};

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            for(int i=0;i<places.length;i++){
                String s[]=places[i];
                boolean isOk=true;

                for(int j=0;j<5;j++){
                    for(int k=0;k<5;k++){
                        if(s[j].charAt(k)=='P'){
                            if(!bfs(j,k,s)){
                                isOk=false;
                            }
                        }
                    }
                }
                answer[i]=isOk?1:0;
            }

            return answer;
        }

        public static boolean bfs(int r, int c, String s[]){

            Queue<int[]> q=new LinkedList<>();
            boolean visited[][]=new boolean[5][5];
            q.add(new int[]{r,c});
            visited[r][c]=true;

            while(!q.isEmpty()){

                int now[]=q.poll();
                int br=now[0];
                int bc=now[1];

                for(int i=0;i<4;i++){
                    int nr=br+dr[i];
                    int nc=bc+dc[i];

                    if(nr<0 || nc<0 || nr>=5 || nc>=5){
                        continue;
                    }
                    if(visited[nr][nc]) continue;

                    int d=Math.abs(r-nr)+Math.abs(c-nc);

                    if(d<=2 && s[nr].charAt(nc)=='P'){
                        return false;
                    }
                    else if(d<2 && s[nr].charAt(nc)=='O'){
                        visited[nr][nc]=true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            return true;
        }
    }
}
