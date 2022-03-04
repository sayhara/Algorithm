package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1593 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int g=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());

        char[] g_c=br.readLine().toCharArray();
        char[] s_c=br.readLine().toCharArray();

        int[] gAlpha=new int[52];
        for(int i=0;i<g;i++){
            if(g_c[i]<'a') gAlpha[g_c[i]-'A']++;
            else gAlpha[g_c[i]-'a'+26]++;
        }

        int[] sAlpha=new int[52];
        int len=0,answer=0,from=0;
        for(int i=0;i<s;i++){
            if(s_c[i]<'a') sAlpha[s_c[i]-'A']++;
            else sAlpha[s_c[i]-'a'+26]++;
            len++;

            if(len==g){
                if(same(gAlpha,sAlpha)) answer++;

                if(s_c[from]<'a') sAlpha[s_c[from]-'A']--;
                else sAlpha[s_c[from]-'a'+26]--;
                len--; from++;
            }
        }
        System.out.println(answer);
    }

    public static boolean same(int[] g, int[] s){
        for(int i=0;i<52;i++)
            if(g[i]!=s[i]) return false;
        return true;

    }
}
