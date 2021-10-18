package codeup;

import java.util.Scanner;

public class CodeUp_1034 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String a=sc.nextLine();
		
		int b=Integer.valueOf(a,8); // a를 8진수로 변환
		// int b=Integer.parseInt(n,8);
		System.out.printf("%d",b);
		
	}

}

