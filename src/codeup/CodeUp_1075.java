package codeup;

import java.util.Scanner;

public class CodeUp_1075 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		for(int i=n-1;i>-1;i--) {
			System.out.println(i);
			n--;
		}
	
	}

}

