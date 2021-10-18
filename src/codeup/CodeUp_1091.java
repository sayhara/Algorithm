package codeup;

import java.util.Scanner;

public class CodeUp_1091 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Long a=sc.nextLong();
		Long m=sc.nextLong();
		Long d=sc.nextLong();
		Long n=sc.nextLong();
		Long value=a;
		
		for(int i=1;i<n;i++) {
			value=value*m+d;
		}
		
		System.out.println(value);
		
	}
		
}
