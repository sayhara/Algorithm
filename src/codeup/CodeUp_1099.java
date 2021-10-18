package codeup;

import java.util.Scanner;

public class CodeUp_1099 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int arr[][]=new int[11][11];
		int x = 2,y = 2;
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		while(arr[x][y]!=2) { 	// arr[x][y]=2인 경우에는 체크되지 않고 넘어감
			arr[x][y]=9;
			if(arr[x][y+1]!=1) y+=1;
			else if(arr[x+1][y]!=1) x+=1;
			else break;
		}
		
		arr[x][y]=9;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
		
}
