package codeup;

import java.util.Scanner;

public class CodeUp_1095 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int arr[]=new int[n];
		int min=0;
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
			min=arr[0];
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		
		System.out.println(min);
		
	}
		
}
