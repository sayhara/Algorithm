package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_3584 {

    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int result[]=new int[T];

        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            parent=new int[N+1];
            for(int j=0;j<N-1;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int start=Integer.parseInt(st.nextToken()); // 부모
                int end=Integer.parseInt(st.nextToken()); // 자식
                parent[end]=start;
            }
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            Stack<Integer> first=new Stack<>();
            Stack<Integer> second=new Stack<>();

            first.add(x);
            second.add(y);

            while (parent[x]!=0){ // 부모노드를 따라감
                first.add(parent[x]);
                x=parent[x];
            }

            while (parent[y]!=0){
                second.add(parent[y]);
                y=parent[y];
            }

            while (true){

                if(first.isEmpty() || second.isEmpty()){
                    break;
                }

                int stack1 = first.pop();
                int stack2 = second.pop();
                if(stack1!=stack2){
                    break;
                }
                result[i]=stack1;
            }
        }

        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }

    }

}
