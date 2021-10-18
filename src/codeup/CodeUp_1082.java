package codeup;

import java.util.Scanner;

public class CodeUp_1082 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String s=sc.next();
		
		int num=Integer.valueOf(s, 16);
		
		for(int i=1;i<16;i++) {
			System.out.format("%X*%X=%X\n", num,i,num*i);
		}
		
	}
		
}

