package codeup;

import java.util.Scanner;

public class CodeUp_1079 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String a[]=sc.nextLine().split(" ");
		
		for(String i:a) {
			if(i.equals("q")) {
				System.out.println("q");
				break;
			}
			System.out.println(i);
		}
	
	}

}

