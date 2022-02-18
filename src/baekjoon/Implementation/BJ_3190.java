package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3190 {

    static int N,K,L;
    static int arr[][];
    static HashMap<Integer,String> map;
    static List<int[]> snake;
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0}; // 회전

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine()); // 보드의 크기
        K=Integer.parseInt(br.readLine()); // 사과의 개수
        arr=new int[N+1][N+1];
        map=new HashMap<>();

        for(int i=0;i<K;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[r][c]=1;
        }

        L=Integer.parseInt(br.readLine()); // 변환 횟수

        for(int i=0;i<L;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int X=Integer.parseInt(st.nextToken());
            String C=st.nextToken();
            map.put(X,C);
        }

        snake();

    }

    public static void snake(){
        snake=new LinkedList<>();
        snake.add(new int[]{1,1});
        int r=1; int c=1;
        int idx=0;
        int time=0;

        while (true){

            int nr=r+dx[idx];
            int nc=c+dy[idx];
            time++;

            if(getHit(nr,nc)) break; // 부딪히면 stop

            if(arr[nr][nc]==1){ // 사과가 있으면
                arr[nr][nc]=0;
                snake.add(new int[]{nr,nc}); // 머리 정보 추가
            }
            else {
                snake.add(new int[]{nr,nc}); // 다음 칸으로 이동
                snake.remove(0);
            }

            r=nr;
            c=nc;

            if(map.containsKey(time)){
                if(map.get(time).equals("D")){
                    idx++;
                    if(idx==4) idx=0;
                }
                if(map.get(time).equals("L")){
                    idx--;
                    if(idx==-1) idx=3;
                }
            }
        }

        System.out.println(time);

    }

    public static boolean getHit(int nr, int nc) {

        if(nr<1 || nc<1 || nr>N || nc>N){
            return true;
        }

        for(int i=0;i<snake.size();i++){
            if(nr==snake.get(i)[0] && nc==snake.get(i)[1]){
                return true;
            }
        }
        return false;
    }
}
