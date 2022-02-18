package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1062 {

    static int N,K;
    static String[] s;
    static boolean[] alpha;
    static int max=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        s=new String[N];

        for(int i=0;i<N;i++){
            s[i]=br.readLine();
            s[i]= s[i].substring(4, s[i].length() - 4); // rc, hello, car
        }

        if(K<5){
            System.out.println(max);
            return;
        }

        alpha=new boolean[26];
        alpha['a'-97]=true; alpha['n'-97]=true;
        alpha['t'-97]=true; alpha['i'-97]=true;
        alpha['c'-97]=true;

        solve(0,0);
        System.out.println(max);

    }

    public static void solve(int n, int cnt){

        if(cnt==K-5){
            int count=0;
            for(int i=0;i<s.length;i++){

                boolean isRead=true;
                for(int j=0;j<s[i].length();j++){
                    if(!alpha[s[i].charAt(j)-97])
                        isRead=false;
                }
                if(isRead) count++;
            }

            max=Math.max(max,count);
            return;
        }

        for(int i=n;i<26;i++){
            if(!alpha[i]){
                alpha[i]=true;
                solve(i,cnt+1);
                alpha[i]=false;
            }
        }
    }
}
