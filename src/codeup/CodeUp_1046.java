package codeup;

import java.util.Scanner;

public class CodeUp_1046 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		
		System.out.println(a+b+c);
		System.out.println(String.format("%.1f",(float)(a+b+c)/3));
	
	}

}

