package codeup;

import java.util.Scanner;

public class CodeUp_1085 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int h=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int s=sc.nextInt();
		
		float value=(float)h*b*c*s/8/1024/1024;
		
		System.out.format("%.1f MB",value);
		
	}
		
}

