package codeup;

import java.util.Scanner;

public class CodeUp_1080 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		int sum=0;
		int value=0;
		
		for(int i=1;sum<num;i++) {
			sum+=i;
			value=i;
		}
		System.out.println(value);
	
	}

}

