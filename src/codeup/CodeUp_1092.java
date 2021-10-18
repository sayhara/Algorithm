package codeup;

import java.util.Scanner;

public class CodeUp_1092 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int count=0;
		
		while(true) {
			count++;
			if(count%a==0 && count%b==0 && count%c==0) {
				System.out.println(count);
				break;
			}
		}
		
	}
		
}
