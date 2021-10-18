package codeup;

import java.util.Scanner;

public class CodeUp_1090 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Long a=sc.nextLong();
		Long r=sc.nextLong();
		Long n=sc.nextLong();
		Long value=a;
		
		for(int i=1;i<n;i++) {
			value*=r;
		}
		
		System.out.println(value);
		
	}
		
}

// Math.pow를 통해 제곱 표현 가능