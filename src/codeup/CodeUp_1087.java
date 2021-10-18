package codeup;

import java.util.Scanner;

public class CodeUp_1087 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		int count=0,sum=0;
		
		while(true) {
			count++;
			sum+=count;
			
			if(sum>=num) {
				System.out.println(sum);
				break;
			}
		}
		
	}
		
}

