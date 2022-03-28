package baekjoon.Implementation;

import java.io.*;
import java.util.*;

public class BJ_2108 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        int sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
            sum+=arr[i];
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int max=0;
        for(Integer i:map.keySet()){
            if(map.get(i)>max){
                max=map.get(i);
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(Integer i:map.keySet()){
            if(map.get(i)==max){
                list.add(i);
            }
        }

        Arrays.sort(arr);
        Collections.sort(list);

        String format = String.format("%.0f", (double) sum / N);
        System.out.println(format.equals("-0")?0:format); // 산술평균
//        System.out.println(Math.round(sum/N));
        System.out.println(arr[N/2]); // 중앙값
        System.out.println(list.size()==1?list.get(0):list.get(1)); // 최빈값
        System.out.println(Math.abs(arr[N-1]-arr[0])); // 차이
    }

}