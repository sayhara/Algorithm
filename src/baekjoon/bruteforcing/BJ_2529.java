package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_2529 {

    static int k;
    static String[] op;
    static int arr[]={0,1,2,3,4,5,6,7,8,9};
    static int output[]=new int[arr.length];
    static boolean visited[]=new boolean[arr.length];
    static ArrayList<String> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k=Integer.parseInt(br.readLine());
        op=new String[k];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            op[i]=st.nextToken();
        }

        permutation(0);
        Collections.sort(list,Collections.reverseOrder());

        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));

    }

    public static void permutation(int depth){

        if(depth==k+1){
            solve();
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(depth+1);
                visited[i]=false;
            }
        }
    }

    public static void solve(){

        boolean check=true;
        String answer="";

        for(int i=0;i<k;i++){
            int first=output[i];
            int second=output[i+1];
            if(!cal(first,second,op[i])){
                check=false;
                break;
            }
        }
        if(check){
            for (int i=0;i<k+1;i++){
                answer+=output[i];
            }
            list.add(answer);
        }
    }

    public static boolean cal(int n1, int n2, String op){

        if(op.equals("<")){
            if(n1<n2){
                return true;
            }
        }
        else if(op.equals(">")){
            if(n1>n2){
                return true;
            }
        }
        return false;
    }

}