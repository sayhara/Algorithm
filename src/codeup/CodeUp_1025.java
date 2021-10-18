package codeup;

import java.util.Scanner;

public class CodeUp_1025 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String s[]=sc.next().split("");
		
		int num[]=new int[5];
		/*
		for(int i=0;i<s.length();i++) {
			num[i]=s.charAt(i)-'0';
		}
		*/
		num[0]=Integer.parseInt(s[0])*10000;
		num[1]=Integer.parseInt(s[1])*1000;
		num[2]=Integer.parseInt(s[2])*100;
		num[3]=Integer.parseInt(s[3])*10;
		num[4]=Integer.parseInt(s[4]);
		
		for(int i=0;i<num.length;i++) {
			System.out.println("["+num[i]+"]");
		}
	}

}

// charAt(i)-'0'을 이용하면 int형으로 변환 가능
