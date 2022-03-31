package baekjoon.Implementation;

import java.util.*;
import java.io.*;

public class BJ_11559 {

    static char ch[][]=new char[12][6];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int total=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<12;i++){
            ch[i]=br.readLine().toCharArray();
        }

        while (true) {

            boolean now=false;
            visited=new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (ch[i][j] != '.' && !visited[i][j]) {
                        if(checkCount(i,j)){
                            now=true;
                        }
                    }
                }
            }
            if(!now) break;
            total++;
        }
        System.out.println(total);
    }

    public static boolean checkCount(int r, int c){ // 인접한 뿌요의 개수를 파악

        Queue<Pair> q=new LinkedList<>();
        ArrayList<Pair> list=new ArrayList<>(); // 각 큐마다의 개수가 다르기 때문에 ArrayList로 개수 파악
        q.add(new Pair(r,c));
        list.add(new Pair(r,c));
        visited[r][c]=true;

        while (!q.isEmpty()) {

            Pair now = q.poll();
            for (int i = 0; i < 4; i++) {

                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < 12 && nc < 6) {
                    if (ch[r][c] == ch[nr][nc] && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        list.add(new Pair(nr,nc));
                        q.add(new Pair(nr, nc));
                    }
                }
            }
        }
        if(list.size()>=4){
            for(int i=0;i<list.size();i++){
                int nr=list.get(i).r;
                int nc=list.get(i).c;
                ch[nr][nc]='.'; // 초기화
            }
            dropCount();
            return true;
        }
        return false;
    }

    public static void dropCount(){

        for(int i=11;i>=0;i--){ // 배열의 마지막 행에서부터 체크
            for(int j=0;j<6;j++){
                if(ch[i][j]=='.'){
                    for(int k=i-1;k>=0;k--){ // 탐색하고 있는 행의 바로 위의 행부터 체크
                        if(ch[k][j]!='.'){
                            ch[i][j]=ch[k][j]; // 한 블록씩 이동
                            ch[k][j]='.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static class Pair{
        int r;
        int c;

        public Pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

}