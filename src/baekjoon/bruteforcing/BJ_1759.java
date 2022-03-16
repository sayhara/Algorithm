package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1759 {

    static int L,C;
    static String ch[];
    static boolean visited[];
    static ArrayList<String> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        L=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        ch=new String[C];
        visited=new boolean[C];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            ch[i]=st.nextToken();
        }

        Arrays.sort(ch); // 찾기 전에 정렬을 해주면 됨
        combination(0,L);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void combination(int depth, int r){

        if(r==0){
            String result="";
            for(int i=0;i<C;i++){
                if(visited[i]){
                    result+=ch[i];
                }
            }
            if(check(result)){
                list.add(result);
            }
        }

        for(int i=depth;i<C;i++){
            if(visited[i]==false){
                visited[i]=true;
                combination(i+1,r-1);
                visited[i]=false;
            }
        }
    }

    public static boolean check(String result){

        int mo=0; int ja=0;

        for(int i=0;i<result.length();i++){
            char chk=result.charAt(i);
            if(chk=='a' || chk=='e' || chk=='i' || chk=='o' || chk=='u'){
                mo++;
            } else {
                ja++;
            }
        }

        if(mo<1 || ja<2){
            return false;
        }

        return true;
    }
}
