package codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CodeUp_1084 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		int count=0;
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				for(int k=0;k<c;k++) {
					bw.write(i+" "+j+" "+k+"\n");
					count++;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
		
}

//자바에서 System.out.print()는 시간을 오래 잡아먹는다.
//BufferedReader, BufferedWriter를 이용 & String.valueOf()
