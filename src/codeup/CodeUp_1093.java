package codeup;

import java.util.Scanner;

public class CodeUp_1093 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int arr[]=new int[23];
		
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			arr[num-1]++;
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}
		
}
