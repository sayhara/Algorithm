package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182 {

    static int N,S;
    static int arr[];
    static boolean visited[];
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        arr=new int[N];
        visited=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<N+1;i++){
            find(0,i);
        }

        System.out.println(count);

    }

    // start : 시작점, r : 조합 개수
    public static void find(int start, int r){

        if(r==0){
            sum();
            return;
        }

        for(int i=start;i<N;i++){ // 그 다음의 i값이 들어올 수 있도록 visited[i]=false로 초기화
            if(!visited[i]){
                visited[i]=true;
                find(i+1,r-1);
                visited[i]=false;
            }
        }
    }
    
    public static void sum(){

        int sum=0;

        for(int i=0;i<N;i++){
            if(visited[i]==true){
                sum+=arr[i];
            }
        }

        if(sum==S){
            count++;
        }
    }
}
